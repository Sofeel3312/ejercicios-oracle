package com.ojala.books.principal;

import com.ojala.books.model.*;
import com.ojala.books.service.ConsumoAPI;
import com.ojala.books.service.ConvierteDatos;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Principal {
    private final Scanner teclado = new Scanner(System.in);
    private final ConsumoAPI consumoAPI;
    private final String URL_BASE = "https://gutendex.com/";
    private final ConvierteDatos conversor;

    public static final String RESET = "\u001B[0m";
    public static final String TITULO = "\u001B[35m";      // Magenta para encabezados
    public static final String AUTOR = "\u001B[36m";       // Cyan para nombres
    public static final String FECHA = "\u001B[32m";       // Verde para otros datos
    public static final String ALERTA = "\u001B[31m";      // Rojo para datos faltantes
    public static final String LIBRO = "\u001B[34m";       // Azul para títulos de libros

    public Principal (ConsumoAPI consumoAPI, ConvierteDatos conversor) {
        this.consumoAPI = consumoAPI;
        this.conversor = conversor;
    }
    public void muestraElMenu() {

        while (true) {
            System.out.println("╔═════════════════════════════════════════════╗");
            System.out.println("║           Bienvenido al buscador            ║");
            System.out.println("╠═════════════════════════════════════════════╣");
            System.out.println("║  1 - Buscar libro por título                ║");
            System.out.println("║  2 - Listar libros por autor                ║");
            System.out.println("║  3 - Información general de autores         ║");
            System.out.println("║  4 - Listar autores por año de publicación  ║");
            System.out.println("║  5 - Listar libros por idioma               ║");
            System.out.println("║  6 - Sinopsis de libro                      ║");
            System.out.println("║  7 - Historial de libros consultados        ║");
            System.out.println("║  0 - Salir                                  ║");
            System.out.println("╚═════════════════════════════════════════════╝");
            System.out.println("************************************************************");

            int opcion;
            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    buscarPorTitulo();
                    break;
                case 2:
                    listarPorAutor();
                    break;
                case 3:
                    autoresRegistrados();
                    break;
                case 4:
                    listarAutoresPorAno();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    sinopsisLibro();
                    break;
                case 7:
                    historialConsultado();
                    break;
                case 0:
                    System.out.println("Gracias por usar el buscador.\nOja.la vuelva pronto Ψ(￣∀￣)Ψ");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void buscarPorTitulo() {
        System.out.println(AUTOR + "Ingresa el título del libro: " + RESET);
        String titulo = teclado.nextLine().trim();
        List<Book> libros = buscarLibros(titulo);

        if (titulo.isBlank()) {
            System.out.println("No se encontró ningún libro con ese título.");
        } else {
            mostrarFichaLibro(libros.get(0)); // Solo el primero
        }
    }

    private String normalizaNombre(String input) {
        input = input.trim();

        long comas = input.chars().filter(c -> c == ',').count();
        if (comas > 1) {
            System.out.println(ALERTA + "Demasiadas comas. Usa solo una: 'Apellido, Nombre'" + RESET);
            return input;
        }

        if (comas == 1) {
            String[] partes = input.split(",");
            if (partes.length == 2) {
                return partes[1].trim() + " " + partes[0].trim(); // "nombre apellido"
            } else {
                System.out.println(ALERTA + "Formato incorrecto. Usa solo una coma: 'Apellido, Nombre'" + RESET);
                return input;
            }
        }

        return input; // sin coma, se deja como está
    }


    private void listarPorAutor() {
        System.out.println(AUTOR + "Búsqueda por autor:" + RESET);
        System.out.println("Formato sugerido: 'Apellido, Nombre'");
        System.out.println("No utilices comas o el nombre completo");
        System.out.println("Ejemplo: 'Poe' o 'Edgar Allan',");
        System.out.println(TITULO + "----------------------------------" + RESET);

        String input = teclado.nextLine().trim().toLowerCase();
        String autorBuscado = normalizaNombre(input);

        List<Book> libros = buscarLibros(autorBuscado);

        List<Book> filtrados = libros.stream()
                .filter(libro -> libro.autores().stream()
                        .anyMatch(a -> a.name().toLowerCase().contains(autorBuscado)))
                .toList();

        if (filtrados.isEmpty()) {
            System.out.println("No se encontraron libros para ese autor.");
        } else {
            System.out.println("Libros encontrados:");
            filtrados.forEach(this::mostrarFichaLibro);
        }
    }

    private List<Book> buscarLibros(String criterio) {
        String urlBusqueda = URL_BASE + "books/?search=" + criterio.replace(" ", "+");
        String json = consumoAPI.obtenerDatos(urlBusqueda);

        if (json == null || json.isEmpty()) return List.of();

        ResultadoBusqueda resultado = conversor.deserializa(json, ResultadoBusqueda.class);
        if (resultado == null || resultado.getResults() == null) return List.of();

        return resultado.getResults().stream()
                .map(LibroEpilogo::toBook)
                .toList();
    }

    private void mostrarFichaLibro(Book libro) {
        String autores = libro.autores().isEmpty()
                ? "Autor desconocido"
                : libro.autores().stream()
                .map(Author::nombreFormateado)
                .collect(Collectors.joining(" | "));

        String idioma = libro.idiomas().isEmpty() ? "desconocido" : libro.idiomas().get(0);

        System.out.println(TITULO + "---------------LIBRO---------------" + RESET );
        System.out.printf(LIBRO + "Título: " + RESET +    "%s%n", libro.titulo());
        System.out.printf(AUTOR + "Autor: " + RESET +    "%s%n", autores);
        System.out.printf(FECHA + "Idioma: " + RESET +    "%s%n", idioma);
        System.out.printf(FECHA + "Descargas: " + RESET +    "%d%n", libro.descargas());
        System.out.println(TITULO + "------------------------------------" + RESET);
    }


    private void autoresRegistrados() {
        System.out.println(AUTOR + "Ingresa el nombre del autor:" + RESET);
        System.out.println("Formato sugerido: 'Apellido, Nombre'");
        System.out.println("No utilices comas o el nombre completo");
        System.out.println("Ejemplo: 'Poe' o 'Edgar Allan',");
        System.out.println(TITULO + "----------------------------------" + RESET);

        String input = teclado.nextLine().trim().toLowerCase();
        String nombreAutor = normalizaNombre(input);
        List<Book> libros = buscarLibros(nombreAutor);

        List<Book> filtrados = libros.stream()
                .filter(libro -> libro.autores().stream()
                        .anyMatch(a -> a.name().toLowerCase().contains(nombreAutor.toLowerCase())))
                .toList();

        if (filtrados.isEmpty()) {
            System.out.println("No se encontraron autores con ese nombre.");
            return;
        }

        Author autor = filtrados.stream()
                .flatMap(libro->libro.autores().stream())
                .filter(a -> a.name().toLowerCase().contains(nombreAutor.toLowerCase()))
                .findFirst()
                .orElse(null);

        if (autor == null) {
            System.out.println("No se pudo extraer información del autor.");
            return;
        }

        String nacimiento = autor.birthYear() != null ? autor.birthYear().toString() : "Desconocido";
        String fallecimiento;
        if (autor.deathYear() != null) {
            fallecimiento = autor.deathYear().toString();
        } else if (autor.birthYear() != null && autor.birthYear() < 1920) {
            fallecimiento = "Fallecido (fecha desconocida)";
        } else {
            fallecimiento = "Aún vivo o sin registro";
        }

        List<String> titulos = filtrados.stream()
                .map(Book::titulo)
                .map(String::trim)
                .map(String::toLowerCase)
                .distinct()
                .limit(5)
                .collect(Collectors.toList());

        System.out.println(TITULO + "---------------LIBRO---------------" + RESET);
        System.out.printf(AUTOR + "Autor:                   " + RESET + "%s%n", autor.name());
        System.out.printf(FECHA + "Fecha de nacimiento:     " + RESET + "%s%n", nacimiento);
        System.out.printf(FECHA + "Fecha de fallecimiento:  " + RESET + "%s%n",
                (fallecimiento != null ? fallecimiento : ALERTA + "Dato no disponible") + RESET);
        System.out.println(LIBRO + "Libros:" + RESET);
        titulos.forEach(titulo-> System.out.println("                          " + titulo));
        System.out.println(TITULO + "------------------------------------" + RESET);
    }


    private void listarAutoresPorAno() {
        System.out.println(AUTOR + "Consulta por rango de vida de autores" + RESET);
        System.out.print("Año inicial (ej. -500): ");
        String inputInicio = teclado.nextLine().trim();
        System.out.print("Año final (ej. 1899): ");
        String inputFin = teclado.nextLine().trim();

        int inicio, fin;
        try {
            inicio = Integer.parseInt(inputInicio);
            fin = Integer.parseInt(inputFin);
            if (inicio > fin) {
                System.out.println(ALERTA + "El año inicial no puede ser mayor que el final." + RESET);
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println(ALERTA + "Los años deben ser números enteros. Usa valores como -500 o 1899." + RESET);
            return;
        }

        System.out.printf("Buscando libros con autores vivos entre %d y %d...%n", inicio, fin);

        List<Book> libros = buscarLibros(""); // Ajusta si usas filtros

        List<Book> filtrados = libros.stream()
                .filter(libro -> libro.autores().stream().anyMatch(autor -> {
                    Integer nacimiento = autor.birthYear();
                    Integer muerte = autor.deathYear();

                    if (nacimiento == null && muerte == null) return false;

                    int inicioVida = nacimiento != null ? nacimiento : Integer.MIN_VALUE;
                    int finVida = muerte != null ? muerte : Integer.MAX_VALUE;

                    return finVida >= inicio && inicioVida <= fin;
                }))
                .toList();

        if (filtrados.isEmpty()) {
            System.out.println(ALERTA + "No se encontraron libros con autores en ese rango de fecha." + RESET);
            return;
        }

        System.out.println(TITULO + "\nLibros con autores vivos entre " + inicio + " y " + fin + ":" + RESET);
        for (Book libro : filtrados) {
            String autores = libro.autores().isEmpty()
                    ? "Autor desconocido"
                    : libro.autores().stream()
                    .map(Author::nombreFormateado)
                    .collect(Collectors.joining(" | "));

            System.out.printf(TITULO+ "%s%n" + RESET, libro.titulo());
            System.out.printf("    " + AUTOR + "Autor: " + RESET + "%s%n", autores);
            System.out.println(FECHA + "    Descargas: " + RESET +libro.descargas());
            System.out.println(TITULO + "--------------------------------------------------" + RESET);
        }
    }

    public void listarLibrosPorIdioma() {
        System.out.println(AUTOR + "Consulta libros por idioma:" + RESET);
        MenuIdiomas.mostrarMenuIdiomas();

        String entrada = teclado.nextLine().trim().toLowerCase();

        if (entrada.isBlank()) {
            System.out.println(ALERTA + "No se ingresó ningún idioma. Puedes intentar con: en, fr, es..." + RESET);
            return;
        }

        List<String> codigosValidos = Arrays.stream(entrada.split(","))
                .map(String::trim)
                .filter(codigo -> Arrays.stream(Idioma.values())
                        .map(Idioma::getCodigo)
                        .anyMatch(valido -> valido.equalsIgnoreCase(codigo)))
                .toList();

        if (codigosValidos.isEmpty()) {
            System.out.println(ALERTA + "Ninguno de los códigos ingresados es válido.");
            System.out.println("Códigos válidos: en, fr, de, es, pt, otros" + RESET);
            return;
        }

        String url = URL_BASE + "books/?languages=" + String.join(",", codigosValidos);
        String json = consumoAPI.obtenerDatos(url);
        ResultadoBusqueda resultado = conversor.deserializa(json, ResultadoBusqueda.class);

        if (resultado == null || resultado.getResults().isEmpty()) {
            System.out.println(ALERTA + "No se encontraron libros en los idiomas seleccionados." + RESET);
            return;
        }
        List<Book> filtrados = resultado.getResults().stream()
                .map(LibroEpilogo::toBook)
                .toList();
        System.out.println("\nLibros encontrados por idioma: ");
        Map<String, Long> conteoPorIdioma = filtrados.stream()
                .flatMap(libro -> libro.idiomas().stream())
                .filter(codigosValidos::contains)
                .collect(Collectors.groupingBy(idioma -> idioma, Collectors.counting()));

        for (String codigo : codigosValidos) {
            String nombre = Arrays.stream(Idioma.values())
                    .filter(i -> i.getCodigo().equalsIgnoreCase(codigo))
                    .map(Idioma::getNombre)
                    .findFirst()
                    .orElse("Idioma desconocido");

            long cantidad = conteoPorIdioma.getOrDefault(codigo, 0L);
            System.out.printf("  %-15s (%s): %d%n", nombre, codigo, cantidad);
        }

        System.out.println(TITULO + "\nLibros en idiomas: " + String.join(", ", codigosValidos) + RESET);
        for (Book libro : filtrados) {
            String autores = libro.autores().isEmpty()
                    ? "Autor desconocido"
                    : libro.autores().stream()
                    .map(Author::nombreFormateado)
                    .collect(Collectors.joining(" | "));

            System.out.printf(TITULO + "%s%n" + RESET, libro.titulo());
            System.out.printf("    " + AUTOR + "Autor: " + RESET + "%s%n", autores);
            System.out.println(FECHA + "    Idiomas: " + RESET + String.join(", ", libro.idiomas()));
            System.out.println(FECHA + "    Descargas: " + RESET + libro.descargas());
            System.out.println(TITULO + "--------------------------------------------------" + RESET);
        }
    }

    private void sinopsisLibro() {
        System.out.println(AUTOR + "¿Tienes curiosidad por saber de que va el libro?\n" +
                "Escribe el título del libro que deseas consultar:" + RESET);
        Scanner scanner = new Scanner(System.in);
        String titulo = scanner.nextLine().trim();

        if (yaConsultado(titulo)) {
            System.out.println(ALERTA + "Este libro ya fue consultado. Intenta con otro título." + RESET);
            return;
        }

        String url = URL_BASE + "books/?search=" + titulo.replace(" ", "%20");
        String json = consumoAPI.obtenerDatos(url);
        ResultadoBusqueda resultado = conversor.deserializa(json, ResultadoBusqueda.class);

        if (resultado == null || resultado.getResults() == null || resultado.getResults().isEmpty()) {
            System.out.println(ALERTA + "No se encontró ningún libro con ese título." + RESET);
            return;
        }

        List<Book> libros = resultado.getResults().stream()
                .map(LibroEpilogo::toBook)
                .toList();

        for (Book libro : libros) {
            if (libro.autores() == null || libro.autores().isEmpty()) continue;

            String autores = libro.autores().stream()
                    .map(Author::nombreFormateado)
                    .collect(Collectors.joining(" | "));
            String sinopsis = obtenerSinopsis(libro);

            System.out.println(TITULO + "---------------LIBRO---------------" + RESET);
            System.out.printf(LIBRO + "Título: " + RESET + "%s%n", libro.titulo());
            System.out.printf(AUTOR + "Autor: " + RESET + "%s%n", autores);
            System.out.printf(FECHA + "Sinopsis: " + RESET);
            System.out.println(justificarTexto(sinopsis, 80));
            System.out.println(TITULO + "--------------------------------------------------" + RESET);

            historialConsultas.add(new ConsultaLibro(titulo));
            break;
        }
    }

    private String obtenerSinopsis(Book libro) {
        if (libro.summaries() != null && !libro.summaries().isEmpty()) {
            return libro.summaries().get(0);
        }
        if (libro.descripcion() != null && !libro.descripcion().isBlank()) {
            return libro.descripcion();
        }
        return "Sinopsis no disponible.";
    }

    private String justificarTexto(String texto, int anchoMaximo) {
        String[] palabras = texto.split(" ");
        StringBuilder linea = new StringBuilder();
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (linea.length() + palabra.length() + 1 > anchoMaximo) {
                resultado.append(linea.toString().strip()).append("\n");
                linea.setLength(0);
            }
            linea.append(palabra).append(" ");
        }

        if (linea.length() > 0) {
            resultado.append(linea.toString().strip()).append("\n");
        }

        return resultado.toString();
    }

    private final List<ConsultaLibro> historialConsultas = new ArrayList<>();
    private boolean yaConsultado(String titulo) {
        return historialConsultas.stream()
                .anyMatch(c -> c.getTitulo().equalsIgnoreCase(titulo));
    }


    private void historialConsultado() {
        if (historialConsultas.isEmpty()) {
            System.out.println(ALERTA + "Aún no has consultado ningún libro." + RESET);
            return;
        }

        System.out.println(TITULO + "Historial de libros consultados por sinopsis:" + RESET);
        historialConsultas.forEach(c -> System.out.println(LIBRO + c.toString() + RESET));
    }

}



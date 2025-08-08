package com.conversor.alura.principal;

import com.conversor.alura.model.Divisas;
import com.conversor.alura.model.ExchangeRateResponse;
import com.conversor.alura.model.HistorialCambio;
import com.conversor.alura.model.Moneda;
import com.conversor.alura.service.ConsumoAPI;
import com.conversor.alura.service.ConvierteDatos;
import com.conversor.alura.service.HistorialService;

import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY = "96afc69222168fce37383842";
    private ConvierteDatos conversor = new ConvierteDatos();
    private HistorialService historialService = new HistorialService();


    public static void main(String[] args) {
        Principal app = new Principal();
        app.muestraElMenu();
    }

    public void muestraElMenu() {
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("""
                    ************************************************************
                    Bienvenido al conversor de monedas de Orquídea de plata (❁´◡`❁)\n
                    ===Convertir===\n
                    1 - USD >>> MXN
                    2 - MXN >>> USD
                    3 - EUR >>> MXN
                    4 - MXN >>> EUR
                    5 - Menú de divisas
                    6 - Convertir entre otras monedas
                    7 - Ver historial de conversiones
                   
                    0 - Salir
                    """);

            System.out.print(" (✿◡‿◡) Selecciona una opción válida:(✿◡‿◡)\n");
            System.out.println("************************************************************");

            try {
                opcion = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    convertir("USD", "MXN");
                    break;
                case 2:
                    convertir("MXN", "USD");
                    break;
                case 3:
                    convertir("EUR", "MXN");
                    break;
                case 4:
                    convertir("MXN", "EUR");
                    break;
                case 5:
                    menuDeDivisas();
                    break;
                case 6:
                    convertirLibre();
                    break;
                case 7:
                    mostrarHistorial();
                    break;
                case 0:
                    System.out.println("Gracias por usar el conversor plateado.\nVuelva pronto Ψ(￣∀￣)Ψ");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

        private void convertir(String base, String destino) {
        System.out.print("\n( $ _ $ )\nIngresa el valor que deseas convertir de " + base + " a " + destino + ".");
        System.out.println("\nMonto en " + base + ": ");
        double monto = Double.parseDouble(teclado.nextLine());

        String url = URL_BASE + API_KEY + "/latest/" + base;
        String json = consumoAPI.obtenerDatos(url);
        ExchangeRateResponse respuesta = conversor.obtenerDatos(json, ExchangeRateResponse.class);

        if (respuesta.getConversion_rates().containsKey(destino)) {
            double tasa = respuesta.getConversion_rates().get(destino);
            double resultado = monto * tasa;
            System.out.println("\nEl valor " + monto + " [" + base + "] corresponde al valor final de >>> "
            + String.format("%.2f", resultado) + " [" + destino + "]");
            String fecha = java.time.LocalDate.now().toString();
            HistorialCambio cambio = new HistorialCambio(fecha, base, destino, monto, resultado, tasa);
            historialService.guardarCambio(cambio);
        } else {
            System.out.println("Moneda destino no disponible en la API.");
        }

        }

    private void convertirLibre() {
        System.out.print("Moneda base (ej. USD): ");
        String base = teclado.nextLine().toUpperCase();
        if (!esCodigoValido(base)) {
            System.out.println("Código de moneda base inválido.");
            return;
        }
        System.out.print("Moneda destino (ej. EUR): ");
        String destino = teclado.nextLine().toUpperCase();
        if (!esCodigoValido(destino)) {
            System.out.println("Código de moneda destino inválido.");
            return;
        }

        convertir(base, destino);
    }

    private void menuDeDivisas() {
        for (Divisas divisas : Divisas.values()) {
            System.out.printf("🔹 %4s - %-25s (%s)%n", divisas.getCodigo(), divisas.getNombre(), divisas.getPais());
        }
    }

    private void mostrarHistorial() {
        List<HistorialCambio> historial = historialService.cargarHistorial();
        if (historial.isEmpty()) {
            System.out.println("No hay historial disponible.");
            return;
        }

        System.out.println("\nHistorial de conversiones:");
        for (HistorialCambio h : historial) {
            System.out.printf("→ [%s] %.2f %s → %.2f %s (Tasa: %.4f)%n",
                    h.getFecha(), h.getMonto(), h.getBase(), h.getResultado(), h.getDestino(), h.getTasa());
        }
        System.out.println();
    }

    private boolean esCodigoValido(String codigo) {
        for (Divisas d : Divisas.values()) {
            if (d.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
        }
        return false;
    }
}

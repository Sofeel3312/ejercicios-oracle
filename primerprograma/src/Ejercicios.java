import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//public class Ejercicios {
//    public static void main(String[] args) {
//        double temperaturaEnCelsius = 30.4;
//        double temperaturaEnFahrenheit = (temperaturaEnCelsius * 1.8) + 32;
//
//        String mensaje = String.format("La temperatura de %f Celsius es equivalente a %f Fahrenheit", temperaturaEnCelsius, temperaturaEnFahrenheit);
//
//        System.out.println(mensaje);
//
//        int temperaturaEnFahrenheitEntero = (int) temperaturaEnFahrenheit;
//        System.out.println("La temperatura en Fahrenheit entera es: " + temperaturaEnFahrenheitEntero);
//        }
//    }
//                Scanner scanner = new Scanner(System.in);
//
//                System.out.print("Digite su nombre: ");
//                String nombre = scanner.nextLine();
//                System.out.print("Digite su edad: ");
//                int edad = scanner.nextInt();
//                System.out.print("Digite el monto que deseas invertir este mes: ");
//                double valor = scanner.nextDouble();
//
//                System.out.println(nombre + " que tiene " + edad + " años, irá invertir $ " + valor + " este mes.");
//
//                scanner.close();
//            }
//        }
//        switch (expresion) {
//            case valor1:
//                // código a ejecutar si la expresión es igual a valor1
//                break;
//            case valor2:
//                // código a ejecutar si la expresión es igual a valor2
//                break;
//            // otros casos posibles...
//            default:
//                // código a ejecutar si ninguno de los casos anteriores se cumple
//        }
//    }
//}
//        int dia = 3;
//        switch (dia) {
//            case 1:
//                System.out.println("El día 1 es lunes");
//                break;
//            case 2:
//                System.out.println("El día 2 es martes");
//                break;
//            case 3:
//                System.out.println("El día 3 es miércoles");
//                break;
//            // otros casos posibles...
//            default:
//                System.out.println("Día no válido");
//        }
//    }
//}
//public class Ejercicios {
//
//    public static void main(String[] args) {
//        int contador = 1;
//
//        while(contador <= 10) {
//            System.out.println(contador);
//            contador++;
//        }
//    }
//}
//public class Ejercicios {
//
//    public static void main(String[] args) {
//
//        int contador = 1;
//
//        while(contador <= 10) {
//            System.out.println(contador);
//            contador++;
//        }
//    }
//}
//public class Ejercicios {
//    public static void main(String[] args) {
//        for(int contador = 1; contador <= 10; contador++) {
//            System.out.println(contador);
//        }
//    }
//}
//public class Ejercicios {
//    public static void main(String[] args) {
//        Scanner lector = new Scanner(System.in);
//        int numeroGenerado = new Random().nextInt(100);
//        int intentos = 0;
//
//        while (intentos < 5){
//            System.out.println("Digite un número entre el 0 y el 100: ");
//            int numeroDeUsuario = lector.nextInt();
//            intentos++;
//
//            if (numeroDeUsuario == numeroGenerado) {
//                System.out.println("Felicidades, adivinaste el número en " + intentos + " intentos!");
//                break; // interrumpe el loop while
//            } else if (numeroDeUsuario < numeroGenerado) {
//                System.out.println("El número que escribiste es menor al número generado.");
//            } else {
//                System.out.println("El número que escribiste es mayor al número generado.");
//            }
//        }
//        if (intentos == 5) {
//            System.out.println("Lo siento, no conseguiste adivinar el número en 5 intentos. El número era " + numeroGenerado);
//        }
//    }
//}

//public class Ejercicios {
//    public static void main(String[] args) {
//        Scanner aplicacionBancaria = new Scanner(System.in);
//        double saldoActualizado = 1_300.00; // Saldo inicial
//        int opcionesUsuario = 0;
//        int regresarMenu = 9; // Opción para salir
//
//        do {
//            // Mostrar menú de opciones
//            System.out.println("Escriba el número de la opción deseada");
//            System.out.println("1. Consulta de saldo");
//            System.out.println("2. Retirar");
//            System.out.println("3. Depositar");
//            System.out.println("9. Salir");
//
//            // Leer la opción seleccionada por el usuario
//            opcionesUsuario = aplicacionBancaria.nextInt();
//
//            switch (opcionesUsuario) {
//                case 1:
//                    // Consulta de saldo
//                    System.out.println("El saldo actualizado es: " + saldoActualizado);
//                    break;
//                case 2:
//                    // Retiro
//                    System.out.print("Ingrese el monto a retirar: ");
//                    double montoRetiro = aplicacionBancaria.nextDouble();
//                    if (montoRetiro <= saldoActualizado) {
//                        saldoActualizado -= montoRetiro;
//                        System.out.println("Has retirado: " + montoRetiro);
//                        System.out.println("Saldo actualizado: " + saldoActualizado);
//                    } else {
//                        System.out.println("Saldo insuficiente.");
//                    }
//                    break;
//                case 3:
//                    // Depósito
//                    System.out.print("Ingrese el monto a depositar: ");
//                    double montoDeposito = aplicacionBancaria.nextDouble();
//                    saldoActualizado += montoDeposito;
//                    System.out.println("Has depositado: " + montoDeposito);
//                    System.out.println("Saldo actualizado: " + saldoActualizado);
//                    break;
//                case 9:
//                    // Salir
//                    System.out.println("Saliendo del sistema...");
//                    break;
//                default:
//                    // Opción inválida
//                    System.out.println("Opción no válida, por favor intente de nuevo.");
//            }
//        } while (opcionesUsuario != regresarMenu); // Repite hasta que se seleccione la opción 9 (Salir)
//
//        aplicacionBancaria.close();
//    }
//}
public class Ejercicios {
    public static void main(String[] args) {

        //array

    }
}

/*
        Pelicula[] peliculas= new Pelicula[2];

        Pelicula pelicula1 = new Pelicula("Avatar", 2009);
        Pelicula pelicula2 = new Pelicula("El señor de los anillos", 2001);

        peliculas[0] = pelicula1;
        peliculas[1] = pelicula2;
 */
        /*
        int[] numeros = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }
        System.out.println(Arrays.toString(numeros));
*/

        /*
        //suma de los primeros N números
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un número: ");
        int n = scanner.nextInt();
        int suma = 0, i = 1;
        System.out.println();
        while (i <= n) {
            suma += i;
            i++;
        }
        System.out.println("La suma es: " + suma);
        */

        /*
        // Contar del 1 al 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
*/

/*
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el día de la semana (en minúsculas): ");
        String dia = scanner.nextLine();

        scanner.close();

        if (dia.equals("lunes") || dia.equals("martes") || dia.equals("miércoles") || dia.equals("jueves") || dia.equals("viernes")) {
            System.out.println(dia + " es un día hábil.");
        } else if (dia.equals("sábado") || dia.equals("domingo")) {
            System.out.println(dia + " no es un día hábil.");
        } else {
            System.out.println("No es carácter válido.");
        }
    }
}
*/

/*
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la edad del donante: ");
        int edad = scanner.nextInt();

        System.out.println("Ingrese el peso del donante (en kg): ");
        double peso = scanner.nextDouble();

        scanner.close();

        if (edad >= 18 && edad <= 65 && peso >= 50) {
            System.out.println("El donante es compatible.");
        } else {
            System.out.println("El donante no es compatible. \nMotivo. Debe tener entre 18 y 65 años y pesar más de 50 kg.");
        }

*/

        /*
                Scanner scanner = new Scanner(System.in);
                int codigoCorrecto = 2023;
                int nivelPermisoMinimo = 1;
                int nivelPermisoMaximo = 3;

                System.out.print("Ingrese el código de acceso: ");
                int codigoDigitado = scanner.nextInt();

                System.out.print("Ingrese el nivel de permiso: ");
                int nivelPermiso = scanner.nextInt();

                boolean codigoValido = codigoDigitado == codigoCorrecto;
                boolean permisoValido = nivelPermiso >= nivelPermisoMinimo && nivelPermiso <= nivelPermisoMaximo;

                if (codigoValido && permisoValido) {
                    System.out.println("Acceso permitido. ¡Bienvenido al sistema!");
                } else {
                    System.out.println("Acceso denegado. Motivo(s):");
                    if (!codigoValido) {
                        System.out.println("- Código de acceso incorrecto.");
                    }
                    if (!permisoValido) {
                        System.out.println("- Nivel de permiso inválido.");
                    }
                }
          */

        /*
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la edad del donante: ");
        int edad = scanner.nextInt();

        System.out.print("Ingrese el peso del donante (en kg): ");
        double peso = scanner.nextDouble();

        boolean edadValida = edad >= 18 && edad <= 65;
        boolean pesoValido = peso > 50;

        if (edadValida && pesoValido) {
            System.out.println("El donante es compatible para donar sangre.");
        } else {
            System.out.println("El donante no es compatible. Motivo:");
            if (!edadValida) {
                System.out.println("- Debe tener entre 18 y 65 años.");
            }
            if (!pesoValido) {
                System.out.println("- Debe pesar más de 50 kg.");
            }
        }
        scanner.close();
    */



        /*
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer lado: ");
        int lado1 = scanner.nextInt();

        System.out.println("Ingrese el segundo lado: ");
        int lado2 = scanner.nextInt();

        System.out.println("Ingrese el tercer lado: ");
        int lado3 = scanner.nextInt();

        if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
            System.out.println("Los lados pueden formar un triángulo.");
        } else {
            System.out.println("Los lados no pueden formar un triángulo.");
        }

        scanner.close();

         */

        /*
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar el valor del préstamo: ");
        int valorIngresado = scanner.nextInt();

        scanner.close();

        if (valorIngresado >=1000 && valorIngresado <= 5000) {
            System.out.println("El valor " + valorIngresado + "está dentro del intervalo permitido.");
        } else {
            System.out.println("El valor " + valorIngresado + " no está dentro del intervalo permitido para el préstamo.");
        }
*/


    //copiar codigo arriba

/*
 int valor =  10;
        valor += 15;  //Equivalente al valor = valor + 15, atribuye el valor 15 a la variable valor
        System.out.println(valor);
 */
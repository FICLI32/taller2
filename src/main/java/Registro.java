import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {

    public static void main(String[] args) {
        String[][] registro = new String[50][3];
        Scanner scanner = crearScanner();
        ejecutarMenu(registro, scanner);
    }

    public static void ejecutarMenu(String[][] registro, Scanner scanner) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, registro, scanner);
        } while (opcion != 6);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú Datos Personales");
        System.out.println("1. Agregar persona.");
        System.out.println("2. Mostrar la cantidad de personas mayores de edad.");
        System.out.println("3. Mostrar la cantidad de personas menores de edad.");
        System.out.println("4. Mostrar la cantidad de personas de tercera edad.");
        System.out.println("5. Mostrar la cantidad de personas según  estado civil (Soltero/a - Casado/a).");
        System.out.println("6. salir");
        System.out.print("Seleccione una opción: ");
    }

    public static int leerOpcion() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    break;
                } else {
                    System.out.print("Opción inválida. Intente nuevamente: ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                scanner.next();
            }
        }
        return opcion;
    }

    public static Scanner crearScanner() {
        return new Scanner(System.in);
    }

    public static void ejecutarOpcion(int opcion, String[][] registro, Scanner scanner) {

        switch (opcion) {
            case 1:
                System.out.println("Nombre:");
                String nombre = scanner.nextLine();
                System.out.println("estado civil");
                String Estadocivil = scanner.nextLine();
                System.out.println("edad");
                String edad = scanner.nextLine();
                agregarPersona(registro, nombre, Estadocivil, edad);
                break;
            case 2:
                mayoresDeEdad(registro);
                break;
            case 3:
                ....
                break;
            case 4:
                ....
                break;
            case 5:
                ....
                break;
            case 6:
                System.out.println("Saliendo del sistema.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static int obtenerUltimoEspacio(String[][] registro) {
        return registro.length - validarCupo(registro);
    }

    public static boolean hayCupo(String[][] registro) {
        return validarCupo(registro) != 0;
    }

    public static int validarCupo(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0].equals("")) {
                return registro.length - i;
            }
        }
        return 0;
    }

    public static String[][] agregarPersona(String[][] registro, String nombre, String estadoCivil, String edad) {
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadoCivil;
            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
            return registro;
        } else {
            System.out.println("No hay cupo.");
            return registro;
        }
    }

    public static int mayoresDeEdad (String[][] registro) {
        int mayoresDeEdad = 0;
        int edad;
        for (String[] persona : registro) {
            edad = Integer.parseInt(persona[2]);
            if (edad >= 18) {
                mayoresDeEdad++;
                return mayoresDeEdad;
            }
        }
        return 0;
    }

    public static int menoresDeEdad(String[][] registro) {
        int menoresDeEdad = 0;
        int edad;
        for (String[] persona : registro) {
            edad = Integer.parseInt(persona[2]);
            if (edad < 18) {
                menoresDeEdad++;
                return menoresDeEdad;
            }
        }
        return 0;
    }

    public static int terceraEdad(String[][] registro) {
        int terceraEdad = 0;
        int edad;
        for (String[] persona : registro) {
            edad = Integer.parseInt(persona[2]);
            if (edad > 18) {
                terceraEdad++;
                return terceraEdad;
            }
        }
        return 0;
    }

    public static int Solteros()





}


            } else if (a == 5) {
                int c = 0;
                int d = 0;
                for (double[] persona : registro) {
                    if (persona[1].equals("casado/a")) {
                        c++;
                    } else if (persona[1].equals("soltero/a")) {
                        d++;
                    }
                }


                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if (a == 6) {
                System.out.println("Programa finalizado");
            }
        } while (a == 6);
    }

}




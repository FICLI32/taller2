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
                if (opcion >= 1 && opcion <= 6) {
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
                System.out.println("Estado civil:");
                String Estadocivil = scanner.nextLine();
                System.out.println("Edad:");
                String edad = scanner.nextLine();
                agregarPersona(registro, nombre, Estadocivil, edad);
                break;
            case 2:
                int mayoresDeEdad = mayoresDeEdad(registro);
                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
                break;
            case 3:
                int menoresDeEdad = menoresDeEdad(registro);
                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
                break;
            case 4:
                int terceraEdad = terceraEdad(registro);
                System.out.println("Hay " + terceraEdad + " personas de tercera edad");
                break;
            case 5:
                int soteros = solteros(registro);
                int casados = casados(registro);
                System.out.println("Hay " + casados + " casados/as.");
                System.out.println("Hay " + soteros + " solteros/as.");
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
            if (registro[i][0] == null) {
                return registro.length - i;
            }
        }
        return 0;
    }

    public static void agregarPersona (String[][] registro, String nombre, String estadoCivil, String edad) {
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadoCivil;
            registro[indiceDisponible][2] = edad;
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
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

    public static int solteros(String[][] registro) {
        int solteros = 0;

        for (String[] persona : registro) {
            if (persona[1].equals("soltero") || persona[1].equals("soltera")) {
                solteros++;
                return solteros;
            }
        }
        return 0;
    }

    public static int casados(String[][] registro) {
        int casados = 0;
        for (String[] persona : registro) {
            if (persona[1].equals("casado")||persona[1].equals("casada")) {
                casados++;
                return casados;
            }
        }
        return 0;
    }

}





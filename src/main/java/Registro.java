import java.util.InputMismatchException;
import java.util.Scanner;

public class Registro {

    public static void main(String[] args) {
        String[][] registro = new String[50][3];
        ejecutarMenu(registro);
    }

    public static void ejecutarMenu(String[][] registro){
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, registro);
        } while (opcion != 5);
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

    public static Scanner crearScanner(){
        return new Scanner(System.in);
    }

    public static void ejecutarOpcion(int opcion, String[][]registro) {
        switch (opcion) {
            case 1:
                ....
                break;
            case 2:
                ....
                break;
            case 3:
                ....
                break;
            case 4:
                ....
                break;
            case 5:
                System.out.println("Saliendo del sistema.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    do {




            do {
                try {
                    a = new Scanner(System.in).nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
            }while (a > 0 || a < 6);




            if(a == 1) {
                if(hayCupo(registro)) {
                    int indiceDisponible = obtenerUltimoEspacio(registro);
                    String nombre;
                    String Estadocivil;
                    int edad;




                    while(true) {
                        try {
                            nombre = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            Estadocivil = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    while(true) {
                        try {
                            edad = new Scanner(System.in).nextLine();
                        } catch (InputMismatchException e) {
                            System.err.println("Opción inválida");
                            continue;
                        }
                        break;
                    }




                    registro[indiceDisponible][0] = nombre;
                    registro[indiceDisponible][1] = Estadocivil;
                    registro[indiceDisponible][2] = edad;
                    System.out.println("Persona agregada.");
                } else {
                    System.out.println("No hay cupo.");
                }
            } else if(a == 2) {
                int mayoresDeEdad = 0;




                for (double [] persona : registro) {
                    if (persona[2] >= 18) mayoresDeEdad++;
                }




                System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
            } else if(a == 3) {
                int menoresDeEdad = 0;
                int queSera = obtenerUltimoEspacio(registro);




                for (int i = 0; i < queSera; i++) {
                    if (registro[i][2] < 18) menoresDeEdad++;
                }




                System.out.println("Hay " + menoresDeEdad + " menores de edad.");
            } else if(a == 4) {
                int mmmm = 0;




                for (double [] persona : registro) {
                    if (persona[2] >= 60 && persona[1].equals("casado/a")) {
                        mmmm++;
                    } else if(persona[2] >= 65 && persona[1].equals("soltero/a")) {
                        mmmm++;
                    }
                }
                System.out.println("Hay " + mmmm + " personas de tercera edad");
            } else if(a == 5) {
                int c = 0;
                int d = 0;
                for(double[] persona : registro) {
                    if(persona[1].equals("casado/a")) {
                        c++;
                    } else if(persona[1].equals("soltero/a")) {
                        d++;
                    }
                }




                System.out.println("Hay " + d + " casados/as.");
                System.out.println("Hay " + c + " solteros/as.");
            } else if(a == 6) {
                System.out.println("Programa finalizado");
            }
        }while (a == 6);





    public static int obtenerUltimoEspacio(double [][] registro) {
        return registro.length - opa(registro);
    }




    public static boolean hayCupo(double [][] registro) {
        return opa(registro) != 0;
    }




    public static int opa(double [][] registro) {
        for(int i = 0; i < registro.length; i++) {
            if(registro[i][0].equals("")){
                return registro.length - i;
            }
        }




        return 0;
    }
}




import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        menuPrincipal();
        Scanner scan = new Scanner(System.in);
        while (true) {
            int respuesta = scan.nextInt();
            if (respuesta == 1) {
                opcionIngresar();
                break;
            } else if (respuesta == 2) {
                System.out.println("Opcion de visualizacion");
                opcionVisualizacion();
                break;
            } else {
                System.out.println("Error en la respuesta. Digite un numero correcto");
                continue;
            }
        }
    }

    public static void menuPrincipal() {
        System.out.println("Bienvendios a Twork");
        System.out.println("¡Donde buscar trabajo es un placer!");
        System.out.println("Digite [1] para ingresar");
        System.out.println("Digite [2] para consultar");
    }

    public static void opcionIngresar() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Si ya tiene una cuenta registrada ingrese [1]");
            System.out.println("Si desea registrarse ingrese [2]");
            int respuesta = scan.nextInt();
            if (respuesta == 1) {
                System.out.println("Ingrese su tipo de cuenta: ");
                System.out.println("[1] Empleado");
                System.out.println("[2] Empleador");
                respuesta = scan.nextInt();
                if (respuesta == 1) {
                    Empleado.lecturaEmpleado();
                } else if (respuesta == 2) {
                    Empleador.lecturaEmpleadores();
                }
                break;
            } else if (respuesta == 2) {
                System.out.println("Bienvenido al registro");
                System.out.println("Para registrarse como empleado digite [1]");
                System.out.println("Para registrarse como un Empleador digite [2]");
                respuesta = scan.nextInt();
                if (respuesta == 1) {
                    Empleado.registroEmpleado();

                } else if (respuesta == 2) {
                    Empleador.registroEmpleador();
                }
            }
        }
    }

    public static void opcionVisualizacion() {
        ArrayList<String[]> datosEmpleador = new ArrayList<String[]>();
        Empleador.lecturaDeEmpleadores(datosEmpleador);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < datosEmpleador.size(); i++) {
            System.out.println("Nombre:" + datosEmpleador.get(i)[0] + " -- " + "Ubicacion:" + datosEmpleador.get(i)[2] + " -- " + "Numero de contacto:" + datosEmpleador.get(i)[3] + " -- " + "Correo:" + datosEmpleador.get(i)[4] + " -- " + "Requisitos:" + datosEmpleador.get(i)[5] + " -- " + "Numero de vacantes:" + datosEmpleador.get(i)[6]);
        }
    }
}

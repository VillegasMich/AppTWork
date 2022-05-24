import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int respuesta = Integer.parseInt(JOptionPane.showInputDialog(null, menuPrincipal()));
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

//Este metodo contiene los primeros textos del programa

    public static String menuPrincipal() {
        return "\n" + "Bienvendios a Twork" + "\n" +
                "¡Donde buscar trabajo es un placer!" + "\n" +
                "Digite [1] para ingresar" + "\n" +
                "Digite [2] para consultar";

    }

//Este metodo contiene el algoritmo necesario para ejecutar la opcion Ingresar

    public static void opcionIngresar() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            int respuesta = Integer.parseInt(JOptionPane.showInputDialog("\n" + "Si ya tiene una cuenta registrada ingrese [1]" + "\n" + "Si desea registrarse ingrese [2]"));
            if (respuesta == 1) {
                respuesta = Integer.parseInt(JOptionPane.showInputDialog("\n" + "Ingrese su tipo de cuenta: " + "\n" + "[1] Empleado" + "\n" + "[2] Empleador"));
                if (respuesta == 1) {
                    Empleado.mostrarRecomendaciones(Empleado.lecturaEmpleado());
                } else if (respuesta == 2) {
                    Empleador.mostrarRecomendaciones(Empleador.lecturaEmpleadores()); //MOSTRAR RECOMENDACIONES
                }
                break;
            } else if (respuesta == 2) {
                respuesta = Integer.parseInt(JOptionPane.showInputDialog("\n" + "Bienvenido al registro" + "\n" + "Para registrarse como empleado digite [1]" + "\n" + "Para registrarse como un Empleador digite [2]"));
                if (respuesta == 1) {
                    Empleado.registroEmpleado();

                } else if (respuesta == 2) {
                    Empleador.registroEmpleador();
                }
            }
        }
    }
    public static void opcionVisualizacion() {
        String negocios = "";
        ArrayList<String[]> datosEmpleador = new ArrayList<String[]>();
        Empleador.lecturaDeEmpleadores(datosEmpleador);
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < datosEmpleador.size(); i++) {
           negocios += i+1 + ". " + "NOMBRE: " + datosEmpleador.get(i)[0] + " || " + "UBICACION: " + datosEmpleador.get(i)[2] + " || " + "NUMERO DE CONTACTO: " + datosEmpleador.get(i)[3] + "||" + "CORREO: " + datosEmpleador.get(i)[4] + " || " + "REQUISITOS: " + datosEmpleador.get(i)[5] +  " || " + "NUMERO DE VACANTES: " + datosEmpleador.get(i)[6] + "\n" + "\n";
        }
        JOptionPane.showMessageDialog(null, "\n" + negocios);
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado extends Usuario {

    public Empleado(String nom, String con, String ubic, int tel, String corr) {
        super(nom, con, ubic, tel, corr);
    }

    public static void registroEmpleado() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese su nombre: ");
            String nom = scan.next();
            System.out.println("Ingrese su contraseña: ");
            String cont = scan.next();
            System.out.println("Ingrese su ubicacion: ");
            String ubi = scan.next();
            System.out.println("Ingrese su numero de telefono: ");
            int tele = scan.nextInt();
            String corr;
            while (true){
                System.out.println("Ingrese su correo: ");
                corr = scan.next();
                if (!corr.contains("@")){
                    System.out.println("El correo ingresado no es valido");
                    continue;
                }
                else {
                    break;
                }
            }

            Empleado empleado = new Empleado(nom,cont,ubi,tele, corr);
            escrituraEmpleados(empleado);
            escrituraEmpleados(empleado);
            escrituraEmpleados(empleado);
            System.out.println("Ha quedado registrado como: " +empleado);

            //hacerl lo del archivo
        }

       /*
         public static void lecturaEmpleado() {
                ArrayList<String[]> datosEmpleado = new ArrayList<String[]>();
                lecturaDeEmpleados(datosEmpleado);


                for(int i = 0; i < datosEmpleado.size(); i++){
                    String nombre = datosEmpleado.get(i)[0];
                    String contraseña = datosEmpleado.get(i)[1];

                        if() {
                        System.out.println();
                        System.out.println();
                        break;
                    }
                    else {
                        System.out.println("usuario o contraseña incorrecta");
                    }
                }
            }


            public static void lecturaDeEmpleados(ArrayList<String[]> datosEmpleado) {
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader("Datos1.txt"));
                        String line = null;
                        while((line = reader.readLine()) != null) {
                            String[] datosUsuario = line.split(",");
                            datosEmpleado.add(datosUsuario);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        }
                }
        */


    public static void escrituraEmpleados(Empleado empleado) {
        FileWriter datos;
        {
            try {
                datos = new FileWriter("DatosEmpleados.txt");
                datos.write(empleado.getNombre() + ",");
                datos.write(empleado.getContraseña() + ",");
                datos.write(empleado.getUbicacion() + ",");
                datos.write(empleado.getTelefono()+ ",");
                datos.write(empleado.getCorreo() + "\r\n");
                datos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

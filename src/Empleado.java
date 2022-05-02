import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado extends Usuario {

    public Empleado(String nom, String con, String ubic, Long tel, String corr) {
        super(nom, con, ubic, tel, corr);
    }

    public static void registroEmpleado()  {
            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese su nombre: ");
            String nom = scan.next();
            System.out.println("Ingrese su contraseña: ");
            String cont = scan.next();
            System.out.println("Ingrese su ubicacion: ");
            String ubi = scan.next();
            System.out.println("Ingrese su numero de telefono: ");
            Long tele = scan.nextLong();
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
            System.out.println("Ha quedado registrado como: " +empleado);

            //hacerl lo del archivo
        }


         public static void lecturaEmpleado() {
                ArrayList<String[]> datosEmpleado = new ArrayList<String[]>();
                lecturaDeEmpleados(datosEmpleado);
                Scanner scan = new Scanner(System.in);

                while(true){
                    String nombre = "";
                    String contraseña = "";
                    System.out.println("Ingrese su nombre de usuario: ");
                    String usuario = scan.next();
                    System.out.println("Ingrese su contraseña: ");
                    String contraseña2 = scan.next();

                    for (int i = 0; i < datosEmpleado.size(); i++){
                        nombre = datosEmpleado.get(i)[0];
                        contraseña = datosEmpleado.get(i)[1];
                        if(!nombre.equals(usuario) && !contraseña.equals(contraseña2)){
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                    if (nombre.equals(usuario) && contraseña.equals(contraseña2)){
                        System.out.println("Contraseña correcta :)");
                        break;
                    }
                    else{
                        System.out.println("Usuario o contraseña incorreta");
                        continue;
                    }
                }
            }


            public static void lecturaDeEmpleados(ArrayList<String[]> datosEmpleado) {
                    BufferedReader reader = null;
                    try {
                        reader = new BufferedReader(new FileReader("DatosEmpleados.txt"));
                        String line = null;
                        while((line = reader.readLine()) != null) {
                            String[] datosUsuario = line.split(",");
                            datosEmpleado.add(datosUsuario);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        }
                }



    public static void escrituraEmpleados(Empleado empleado)  {

        File f = new File("DatosEmpleados.txt");
        FileWriter datos = null;
        PrintWriter pw = null;


        if (!f.exists()) {
            try{
                f.createNewFile();
            }catch(IOException exception){
                System.err.println("Error creating the file");
            }
        }

        try {
            datos = new FileWriter("DatosEmpleados.txt",true);
            pw = new PrintWriter(datos);
            pw.println(empleado.getNombre() + "," + empleado.getContraseña() + "," + empleado.getUbicacion() + "," + empleado.getTelefono() + "," + empleado.getCorreo());
            datos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}

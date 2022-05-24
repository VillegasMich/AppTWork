import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Empleado extends Usuario {

    private String profesion;

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }


    public Empleado(String nom, String con, String ubic, Long tel, String corr,String profesion) {
        super(nom, con, ubic, tel, corr);
        this.profesion = profesion;
    }

//Este metodo se encarga de perdirle al empleado la informacion necesaria para registrarlo en el "sistema"

    public static void registroEmpleado()  {
            Scanner scan = new Scanner(System.in);
            String nom = JOptionPane.showInputDialog("Ingrese su nombre:");
            String cont = JOptionPane.showInputDialog("Ingrese si contraseña: ");
            String ubi = JOptionPane.showInputDialog("Ingrese su ubicacion: ");
            Long tele = Long.parseLong(JOptionPane.showInputDialog("Ingrese su numero de telefono:"));
            String corr;
            while (true){

                corr = JOptionPane.showInputDialog("Ingrese su correo: ");
                if (!corr.contains("@")){
                    JOptionPane.showMessageDialog(null, "El correo ingresado no es valido");
                    continue;
                }
                else {
                    break;
                }
            }

            String prof = JOptionPane.showInputDialog("Ingrese su profesion/oficio(Panadero, cocinero, mecanico, etc)");
            Empleado empleado = new Empleado(nom,cont,ubi,tele, corr,prof);
            escrituraEmpleados(empleado);

            JOptionPane.showMessageDialog(null,"Ha quedado registrado como: " + empleado);

        }

//Este metodo se encarga de hacer la autenticacion de empleados previamente registrados y permitirles continiuar si ingresan bien el usuario y la contraseña

         public static String lecturaEmpleado() {
                ArrayList<String[]> datosEmpleado = new ArrayList<String[]>();
                lecturaDeEmpleados(datosEmpleado);
                Scanner scan = new Scanner(System.in);

                while(true){
                    String nombre = "";
                    String contrasena = "";
                    String lugar = "";
                    String profesion = "";
                    String usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
                    String contrasena2 = JOptionPane.showInputDialog("Ingrese contraseña:");

                    for (int i = 0; i < datosEmpleado.size(); i++){
                        nombre = datosEmpleado.get(i)[0];
                        contrasena = datosEmpleado.get(i)[1];
                        lugar = datosEmpleado.get(i)[2];
                        profesion = datosEmpleado.get(i)[5];
                        if(!nombre.equals(usuario) && !contrasena.equals(contrasena2)){
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                    if (nombre.equalsIgnoreCase(usuario) && contrasena.equalsIgnoreCase(contrasena2)){
                        //System.out.println("Usuario y Contraseña correcta");
                        JOptionPane.showMessageDialog(null, "Usuario y Contraseña correcta");
                        return lugar + "-" + profesion;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorreta");
                        continue;
                    }
                }
            }

//Este metodo se encarga de leer el archivo DatosEmpleado.txt

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


//Este metodo usa los valores ingresados en registroEmpleado() y se encarga de almacenarlos en el archivo DatosEmpleados.txt

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
            pw.println(empleado.getNombre() + "," + empleado.getContraseña() + "," + empleado.getUbicacion() + "," + empleado.getTelefono() + "," + empleado.getCorreo() + "," + empleado.getProfesion());
            datos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//Este metodo le muestra a los empleados la informacion de los Empleadores con los que comparte ubucaicon o requisitos/profesion

    public static void mostrarRecomendaciones(String datosUsuario){
        String total = "";
        ArrayList<String[]> datosEmpleador = new ArrayList<String[]>();
        Empleador.lecturaDeEmpleadores(datosEmpleador);
        String lugar = datosUsuario.substring(0, datosUsuario.indexOf("-"));
        String profesion = datosUsuario.substring(datosUsuario.indexOf("-") + 1);


        while (true){
            for (int i = 0; i < datosEmpleador.size(); i++){
                if (lugar.equalsIgnoreCase(datosEmpleador.get(i)[2]) || profesion.equalsIgnoreCase(datosEmpleador.get(i)[5])){
                    total += "\n" + "Sus recomendaciones segun localizacion y requisitos son las siguientes empresas/negocios: " +" \n " + "Nombre: " + datosEmpleador.get(i)[0] + " \n " + "Ubicacion: " + datosEmpleador.get(i)[2] + " \n " + "Numero de contacto: " + datosEmpleador.get(i)[3] + " \n " + "Correo: " + datosEmpleador.get(i)[4] + " \n " + "Requisitos: " + datosEmpleador.get(i)[5] + " \n " + "Numero de vacantes: " + datosEmpleador.get(i)[6] + " \n " + " \n ";
                }
            }
            JOptionPane.showMessageDialog(null, "\n" + total);
            break;
        }
    }
}

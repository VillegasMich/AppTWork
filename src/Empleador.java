import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Empleador extends Usuario{

    private int ofertas;
    private String requi;

    public Empleador(String nom, String con, String ubic, Long tel, String corr, int ofer, String requi) {
        super(nom, con, ubic, tel, corr);
        this.ofertas = ofer;
        this.requi = requi;
    }

    public int getOfertas() {
        return ofertas;
    }

    public void setOfertas(int ofertas) {
        this.ofertas = ofertas;
    }

    public String getRequi() {
        return requi;
    }

    public void setRequi(String requi) {
        this.requi = requi;
    }

    @Override
    public String toString(){
            String encript = getContraseña().replaceAll(getContraseña(), "*******");
            return  "\n" + " - NOMBRE "+ getNombre() + "\n" + " - CONTRASEÑA "+ encript + "\n" + " - UBICACION "+ getUbicacion()+ "\n" + " - TELEFONO " + getTelefono()+ "\n" + " - CORREO "+ getCorreo()+ "\n" + " - REQUISITOS " + getRequi()+ "\n" + " - OFERTAS " + getOfertas();
        }


    public static void registroEmpleador(){
             Scanner scan = new Scanner(System.in);
             String corr;
             String nom = JOptionPane.showInputDialog("Ingrese el nombre del negocio:");
             String cont = JOptionPane.showInputDialog("Ingrese la contraseña :");
             String ubi = JOptionPane.showInputDialog("Ingrese donde esta ubicado su negocio:");
             Long tele = Long.parseLong(JOptionPane.showInputDialog("Ingrese el numero de telefono "));
              while (true){
                   corr = JOptionPane.showInputDialog("Ingrese su correo");
                    if (!corr.contains("@")){
                        JOptionPane.showMessageDialog(null, "El correo ingresado no es valido");
                    }
                    else {
                        break;
                    }
             }
             String requi = JOptionPane.showInputDialog("Ditgite sus requisitos:  ");
             int numOfer = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de ofertas de su negocio: "));
             Empleador empleador = new Empleador(nom, cont, ubi, tele, corr,numOfer, requi);
             JOptionPane.showMessageDialog(null,"Ha quedado registrado como: " + empleador);

             escribirEmpleador(empleador);
        }


        public static void escribirEmpleador(Empleador empleador){


                File f = new File("DatosEmpleador.txt");
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
                    datos = new FileWriter("DatosEmpleador.txt",true);
                    pw = new PrintWriter(datos);
                    pw.println(empleador.getNombre() + "," + empleador.getContraseña() + "," + empleador.getUbicacion() + "," + empleador.getTelefono() + "," + empleador.getCorreo() + "," +  empleador.getRequi() + "," + empleador.getOfertas());
                    datos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


    public static void lecturaDeEmpleadores(ArrayList<String[]> datosEmpleado) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("DatosEmpleador.txt"));
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] datosUsuario = line.split(",");
                datosEmpleado.add(datosUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String lecturaEmpleadores() {
        ArrayList<String[]> datosEmpleador = new ArrayList<String[]>();
        lecturaDeEmpleadores(datosEmpleador);

        while(true){
            String nombre = "";
            String contraseña = "";
            String lugar = "";
            String profesion = "";
            String usuario = JOptionPane.showInputDialog("Ingrese su nombre de usuario:");
            String contraseña2 = JOptionPane.showInputDialog("Ingrese contraseña:");

            for (int i = 0; i < datosEmpleador.size(); i++){
                nombre = datosEmpleador.get(i)[0];
                contraseña = datosEmpleador.get(i)[1];
                lugar = datosEmpleador.get(i)[2];
                profesion = datosEmpleador.get(i)[5];
                if(!nombre.equals(usuario) && !contraseña.equals(contraseña2)){
                    continue;
                }
                else{
                    break;
                }
            }
            if (nombre.equalsIgnoreCase(usuario) && contraseña.equalsIgnoreCase(contraseña2)){
                JOptionPane.showMessageDialog(null, "Usuario y Contraseña correcta");
                return lugar + "-" + profesion;
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorreta");
                continue;
            }
        }
    }

    public static void mostrarRecomendaciones(String datosUsuario){
        String total = "";
        ArrayList<String[]> datosEmpleado = new ArrayList<String[]>();
        Empleado.lecturaDeEmpleados(datosEmpleado);
        String lugar = datosUsuario.substring(0, datosUsuario.indexOf("-"));
        String profesion = datosUsuario.substring(datosUsuario.indexOf("-") + 1);

        System.out.println("Sus recomendaciones segun localizacion y requisitos son las siguientes empresas/negocios: ");
        while (true){
            for (int i = 0; i < datosEmpleado.size(); i++){
                if (lugar.equalsIgnoreCase(datosEmpleado.get(i)[2]) || profesion.equalsIgnoreCase(datosEmpleado.get(i)[5])){
                    total += "Sus recomendaciones segun localizacion y requisitos son las siguientes empresas/negocios: " +" \n " + "Nombre: " + datosEmpleado.get(i)[0] + " \n " + "Ubicacion: " + datosEmpleado.get(i)[2] + " \n " + "Numero de contacto: " + datosEmpleado.get(i)[3] + " \n " + "Correo: " + datosEmpleado.get(i)[4] + " \n "+ "Profesion: " + datosEmpleado.get(i)[5] + " \n ";
                }
            }
            JOptionPane.showMessageDialog(null, "\n" + total);
            break;
        }
    }

}

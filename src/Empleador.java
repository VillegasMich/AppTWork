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
            return "Nombre "+ getNombre() + " - Contraseña "+ encript + " - Ubicacion "+ getUbicacion() + " - Telefono " + getTelefono() + " - Correo "+ getCorreo() + " - Requisitos " + getRequi() + " - Ofertas " + getOfertas();
        }

    //Este metodo se encarga de perdirle al Empleador la informacion necesaria para registrarlo en el "sistema"

    public static void registroEmpleador(){
             Scanner scan = new Scanner(System.in);
             String corr;
             System.out.println("Ingrese el nombre del negocio: ");
             String nom = scan.next();
             System.out.println("Ingrese su contraseña: ");
             String cont = scan.next();
             System.out.println("Ingrese donde esta ubicado su negocio: ");
             String ubi = scan.next();
             System.out.println("Ingrese su numero de telefono empresarial: ");
             Long tele = scan.nextLong();
              while (true){
                  System.out.println("Ingrese su correo: ");
                   corr = scan.next();
                    if (!corr.contains("@")){
                        System.out.println("El correo ingresado no es valido");
                    }
                    else {
                        break;
                    }
             }
             System.out.println("Digite los requisitos para ingresar al trabajo(Ejemplo: Panadero, ayudante etc...): ");
             String requi = scan.next();
             System.out.println("Digite las ofertas de su negocio ");
             int numOfer = scan.nextInt();
             Empleador empleador = new Empleador(nom, cont, ubi, tele, corr,numOfer, requi);
             System.out.println("Ha quedado registrado como: " + empleador);

             escribirEmpleador(empleador);
        }

//Este metodo usa los valores ingresados en registroEmpleador() y se encarga de almacenarlos en el archivo DatosEmpleador.txt

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

//Este metodo se encarga de leer el archivo DatosEmpleador.txt

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

    //Este metodo se encarga de hacer la autenticacion de empleadores previamente registrados y permitirles continiuar si ingresan bien el usuario y la contraseña

    public static void lecturaEmpleadores() {
        ArrayList<String[]> datosEmpleador = new ArrayList<String[]>();
        lecturaDeEmpleadores(datosEmpleador);
        Scanner scan = new Scanner(System.in);

        while(true){
            String nombre = "";
            String contraseña = "";
            System.out.println("Ingrese su nombre de usuario: ");
            String usuario = scan.next();
            System.out.println("Ingrese su contraseña: ");
            String contraseña2 = scan.next();

            for (int i = 0; i < datosEmpleador.size(); i++){
                nombre = datosEmpleador.get(i)[0];
                contraseña = datosEmpleador.get(i)[1];
                if(!nombre.equals(usuario) && !contraseña.equals(contraseña2)){
                    continue;
                }
                else{
                    break;
                }
            }
            if (nombre.equalsIgnoreCase(usuario) && contraseña.equalsIgnoreCase(contraseña2)){
                System.out.println("Usuario y Contraseña correcta");
                break;
            }
            else{
                System.out.println("Usuario o contraseña incorreta");
                continue;
            }
        }
    }

}

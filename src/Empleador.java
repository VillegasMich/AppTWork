import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
}

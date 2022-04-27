import java.util.Scanner;
public class Empleador extends Usuario{

    private int ofertas;
    private String requi;

    public Empleador(String nom, String con, String ubic, int tel, String corr, int ofer, String requi) {
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
            String encrip = getContraseña().replaceAll(getContraseña(), "*******");
            return "Nombre "+ getNombre() + " - Contraseña "+ getContraseña() + " - Ubicacion "+ getUbicacion() + " - Telefono " + getTelefono() + " - Correo "+ getCorreo();
        }

    public static void registroEmpleador(){
             Scanner scan = new Scanner(System.in);
             System.out.println("Ingrese el nombre del negocio: ");
             String nom = scan.next();
             System.out.println("Ingrese su contraseña: ");
             String cont = scan.next();
             System.out.println("Ingrese donde esta ubicado su empresa: ");
             String ubi = scan.next();
             System.out.println("Ingrese su numero de telefono empresarial: ");
             int tele = scan.nextInt();
              while (true){
                  System.out.println("Ingrese su correo: ");
                  String corr = scan.next();
                    if (!corr.contains("@")){
                        System.out.println("El correo ingresado no es valido");
                        continue;
                        }
                    else {
                        break;
                    }
             }
        }
}

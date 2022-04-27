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
            System.out.println("Ha quedado registrado como: " +empleado);
    
            //hacerl lo del archivo
        }
}

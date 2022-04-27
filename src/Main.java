import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        menuPrincipal();
        Scanner scan = new Scanner(System.in);
        while (true){
            int respuesta = scan.nextInt();
            if(respuesta == 1) {
                opcionIngresar();
                break;
            }
            else if(respuesta == 2){
                System.out.println("Opcion de visualizacion");
                break;
            }
            else{
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

    public static void opcionIngresar(){
        System.out.println("Si ya tiene una cuenta registrada ingrese [1]");
        System.out.println("Si desea registrarse ingrese [2]");
        Scanner scan = new Scanner(System.in);
        int respuesta = scan.nextInt();
        while(true) {
            if(respuesta == 1) {

            }
            else if(respuesta == 2) {
                System.out.println("Bienvenido al registro");
                System.out.println("Para registrarse como empleado digite [1]");
                System.out.println("Para registrarse como un Empleador digite [2]");
                respuesta = scan.nextInt();
                if (respuesta == 1){
                    Empleado.registroEmpleado();
                }
                else if(respuesta == 2){
                    Empleador.registroEmpleador();
                }
            }
        }
    }
}


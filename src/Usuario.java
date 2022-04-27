public class Usuario {

    private String nombre;
    private String contraseña;
    private String ubicacion;// Definir ubicaciones.

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Usuario(String n, String c, String u){
        this.contraseña = c;
        this.nombre = n;
        this.ubicacion = u;
    }
    public String toString(){
        return "nombre: "+ this.nombre + "contraseña: "+ this.contraseña + "Ubicacion: "+ this.ubicacion;
    }
}

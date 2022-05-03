public class Usuario {

    private String nombre;
    private String contraseña;
    private String ubicacion;// Definir ubicaciones.
    private Long telefono;
    private String correo;

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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario(String nom, String con, String ubic, Long tel, String corr){
        this.contraseña = con;
        this.nombre = nom;
        this.ubicacion = ubic;
        this.correo = corr;
        this.telefono = tel;
    }
    public String toString(){
        String encrip = this.contraseña.replaceAll(this.contraseña, "*************");
        return "Nombre "+ this.nombre + " -Contraseña "+ encrip + " -Ubicacion "+ this.ubicacion + " -Telefono " + telefono + " -Correo "+ correo;
    }


}

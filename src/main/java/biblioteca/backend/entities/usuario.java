package biblioteca.backend.entities;

public class usuario {

    private int carnet;

    private String correo;

    private String nombre;

    private String rol;

    private String contraseña;

    private String carrera;


    public usuario(int carnet, String nombre, String rol, String contraseña, String carrera, String correo) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
        this.carrera = carrera;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString(){
        return "carnet : " + this.carnet + " nombre : " + this.nombre + " contraseña: " + this.contraseña + " correo: " + this.correo + " rol: " + this.rol + " carrera: " + this.carrera;
    }

}

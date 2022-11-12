package biblioteca.backend.entities;

public class usuario {

    private int id;

    private String correo;

    private String nombre;

    private String rol;

    private String contra;

    private String programa;


    public usuario(int id,String nombre, String rol, String contra, String programa){
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.contra = contra;
        this.programa = programa;

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

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

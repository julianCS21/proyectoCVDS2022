package biblioteca.backend.entities;

public class salaEstudio extends recurso {

    private String nombreSala;

    private String tamaño;

    private String descripcionSala;

    public salaEstudio(int id, String nombre, String ubicacion, String tipo, int capacidad, String descripcion, int disponible, String nombreSala, String tamaño, String descripcionSala) {
        super(id, nombre, ubicacion, tipo, capacidad, descripcion, disponible);
        this.nombreSala = nombreSala;
        this.tamaño = tamaño;
        this.descripcionSala = descripcionSala;
    }


    public String getNombreSala() {
        return nombreSala;
    }

    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getDescripcionSala() {
        return descripcionSala;
    }

    public void setDescripcionSala(String descripcionSala) {
        this.descripcionSala = descripcionSala;
    }
}

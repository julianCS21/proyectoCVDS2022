package biblioteca.backend.entities;

public class computador  extends recurso{

    private String marca;

    private String descripcionComputador;


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcionComputador() {
        return descripcionComputador;
    }

    public void setDescripcionComputador(String descripcionComputador) {
        this.descripcionComputador = descripcionComputador;
    }

    public computador(int id, String nombre, String ubicacion, String tipo, int capacidad, String descripcion, int disponible, String marca, String descripcionComputador) {
        super(id, nombre, ubicacion, tipo, capacidad, descripcion, disponible);
        this.marca = marca;
        this.descripcionComputador = descripcionComputador;
    }
}

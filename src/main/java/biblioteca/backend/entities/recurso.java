package biblioteca.backend.entities;

public class recurso {

    private int id;

    private String nombre;

    private int capacidad;

    private String ubicacion;

    private boolean reservado;

    public recurso(int id, String nombre, int capacidad, String ubicacion, boolean reservado){
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.reservado = reservado;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}

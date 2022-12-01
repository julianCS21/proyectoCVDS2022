package biblioteca.backend.entities;

public class recurso {

    protected int id;

    protected String nombre;

    protected String ubicacion;
    
    protected String tipo;

    protected int capacidad;

    protected String descripcion;

    protected int disponible;



    public recurso(int id, String nombre, String ubicacion, String tipo, int capacidad, String descripcion , int disponible){
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }




    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
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


    @Override
    public String toString(){
        return "id : " + this.id + "nombre : " + this.nombre + "ubicacion: " + this.ubicacion + "tipo: " + this.tipo + "capacidad: " + this.capacidad + "descripcion: " + this.descripcion + "disponible: " + this.disponible;

    }
}

package biblioteca.backend.managedbeans;

import biblioteca.backend.entities.recurso;
import biblioteca.backend.services.ExcepcionServiciosRecurso;
import biblioteca.backend.services.ServiciosRecursos;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean(name = "administrador")

@SessionScoped
public class administradorBean  extends usuarioBean{

    @Inject
    private ServiciosRecursos sr;

    public ServiciosRecursos getSr() {
        return sr;
    }

    public void setSr(ServiciosRecursos sr) {
        this.sr = sr;
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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

    private int id;

    private String nombre;

    private String ubicacion;

    private String tipo;

    private int capacidad;

    private String descripcion;

    private int disponible;



    public administradorBean(){
        super();
    }

    public void añadirRecurso() throws ExcepcionServiciosRecurso {
            sr.añadirRecurso(new recurso(id,nombre,ubicacion,tipo,capacidad,descripcion,disponible));

    }
}

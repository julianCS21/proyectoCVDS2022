package biblioteca.backend.managedbeans;

import biblioteca.backend.entities.recurso;
import biblioteca.backend.entities.tipoDeBusquedas;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.services.ExcepcionServiciosRecurso;
import biblioteca.backend.services.ServiciosRecursos;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;


@ManagedBean(name = "recurso")




@SessionScoped
public class recursoBean extends BasePageBean {

    @Inject
    private ServiciosRecursos sr;

    private String consulta;

    private List<recurso> recursosConsultados;


    public List<recurso> getRecursosConsultados() throws PersistenceException {
        if(tp == tipoDeBusquedas.TODO){
            this.recursosConsultados = obtenerRecurso();
        }
        return this.recursosConsultados;
    }

    public void setRecursosConsultados(List<recurso> recursosConsultados) {
        this.recursosConsultados = recursosConsultados;
    }

    tipoDeBusquedas tp = tipoDeBusquedas.TODO;

    public ServiciosRecursos getSr() {
        return sr;
    }

    public tipoDeBusquedas[] getTiposBusquedas() {
        return tipoDeBusquedas.values();
    }

    public void setSr(ServiciosRecursos sr) {
        this.sr = sr;
    }

    public tipoDeBusquedas getTp() {
        return tp;
    }

    public void setTp(tipoDeBusquedas tp) {
        this.tp = tp;
    }


    public void consulta() throws PersistenceException {
        if(this.tp == tipoDeBusquedas.TODO){
            setRecursosConsultados(obtenerRecurso());
        }
        else if (this.tp == tipoDeBusquedas.TIPO){
            setRecursosConsultados(obtenerRecursoPorTipo(consulta));
        }
        else if(this.tp == tipoDeBusquedas.CAPACIDAD){
            int capacidad = Integer.parseInt(consulta);
            setRecursosConsultados(obtenerRecursoPorCapacidad(capacidad));
        }
        else{
            setRecursosConsultados(obtenerRecursoPorUbicacion(consulta));
        }
    }

    public List<recurso> obtenerRecurso() throws PersistenceException{
        try{

            return sr.obtenerRecurso();
        }catch (ExcepcionServiciosRecurso e){
            throw new PersistenceException("Error al buscar los recursos", e);
        }
    }


    public List<recurso> obtenerRecursoPorTipo(String tipo) throws PersistenceException{
        try{
            return sr.obtenerRecursoPorTipo(tipo);
        }catch (ExcepcionServiciosRecurso e){
            throw new PersistenceException("Error al buscar los recursos", e);
        }
    }


    public List<recurso> obtenerRecursoPorCapacidad(int capacidad) throws PersistenceException{
        try{
            return sr.obtenerRecursoPorCapacidad(capacidad);
        }catch (ExcepcionServiciosRecurso e){
            throw new PersistenceException("Error al buscar los recursos", e);
        }
    }


    public List<recurso> obtenerRecursoPorUbicacion(String ubicacion) throws PersistenceException{
        try{
            return sr.obtenerRecursoPorUbicacion(ubicacion);
        }catch (ExcepcionServiciosRecurso e){
            throw new PersistenceException("Error al buscar los recursos", e);
        }
    }


    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public void buscar(String nombre, String tipo){
        System.out.println(nombre);
        System.out.println(tipo);
    }
}

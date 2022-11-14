package biblioteca.backend.managedbeans;

import biblioteca.backend.entities.recurso;
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





}

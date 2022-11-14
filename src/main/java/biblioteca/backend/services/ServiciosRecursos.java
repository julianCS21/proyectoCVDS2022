package biblioteca.backend.services;

import biblioteca.backend.entities.recurso;
import biblioteca.backend.persistence.PersistenceException;

import java.util.List;

public interface ServiciosRecursos {

    public List<recurso> obtenerRecurso() throws ExcepcionServiciosRecurso;

    public List<recurso> obtenerRecursoPorTipo(String tipo) throws ExcepcionServiciosRecurso;

    public List<recurso> obtenerRecursoPorCapacidad(int capacidad) throws ExcepcionServiciosRecurso;

    public List<recurso> obtenerRecursoPorUbicacion(String ubicacion) throws ExcepcionServiciosRecurso;
}

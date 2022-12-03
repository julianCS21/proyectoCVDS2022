package biblioteca.backend.services;

import biblioteca.backend.entities.computador;
import biblioteca.backend.entities.libro;
import biblioteca.backend.entities.recurso;
import biblioteca.backend.entities.salaEstudio;
import biblioteca.backend.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServiciosRecursos {

    public List<recurso> obtenerRecurso() throws ExcepcionServiciosRecurso;

    public List<recurso> obtenerRecursoPorTipo(String tipo) throws ExcepcionServiciosRecurso;

    public List<recurso> obtenerRecursoPorCapacidad(int capacidad) throws ExcepcionServiciosRecurso;

    public List<recurso> obtenerRecursoPorUbicacion(String ubicacion) throws ExcepcionServiciosRecurso;

    public void añadirRecurso(recurso r) throws  ExcepcionServiciosRecurso;

    public libro consultarLibro(String nombreLibro) throws ExcepcionServiciosRecurso;

    public computador consultarComputador(String nombreComputador) throws ExcepcionServiciosRecurso;

    public salaEstudio consultarSalaEstudio(String nombreSala) throws ExcepcionServiciosRecurso;
}

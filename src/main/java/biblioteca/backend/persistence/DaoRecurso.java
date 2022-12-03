package biblioteca.backend.persistence;

import biblioteca.backend.entities.computador;
import biblioteca.backend.entities.libro;
import biblioteca.backend.entities.recurso;
import biblioteca.backend.entities.salaEstudio;

import java.util.List;

public interface DaoRecurso {

    public List<recurso> loadAll() throws PersistenceException;

    public List<recurso>  loadByType(String tipo) throws PersistenceException;

    public List<recurso>  loadByCapacity(int capacidad) throws PersistenceException;

    public List<recurso>  loadByUbication(String ubicacion) throws PersistenceException;

    public void add(recurso r) throws PersistenceException;

    public libro loadBook(String nombreLibro) throws  PersistenceException;

    public computador loadPC(String nombreComputador) throws PersistenceException;

    public salaEstudio loadStudyClass(String nombreSala) throws PersistenceException;







}

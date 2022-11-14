package biblioteca.backend.persistence;

import biblioteca.backend.entities.recurso;

import java.util.List;

public interface DaoRecurso {

    public List<recurso> loadAll() throws PersistenceException;

    public List<recurso>  loadByType(String tipo) throws PersistenceException;

    public List<recurso>  loadByCapacity(int capacidad) throws PersistenceException;

    public List<recurso>  loadByUbication(String ubicacion) throws PersistenceException;


}

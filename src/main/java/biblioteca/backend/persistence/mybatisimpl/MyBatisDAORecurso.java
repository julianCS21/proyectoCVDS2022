package biblioteca.backend.persistence.mybatisimpl;

import biblioteca.backend.entities.recurso;
import biblioteca.backend.persistence.DaoRecurso;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.persistence.mybatisimpl.mappers.recursoMapper;
import com.google.inject.Inject;

import java.util.List;

public class MyBatisDAORecurso implements DaoRecurso {

    @Inject
    private recursoMapper rm;

    @Override
    public List<recurso> loadAll() throws PersistenceException{
        try {
            return rm.obtenerRecurso();
        }catch (Exception e){
            throw new PersistenceException("error al consultar los recursos:" + e.getLocalizedMessage(),e);
        }
    }

    @Override
    public List<recurso> loadByType(String tipo) throws PersistenceException {
        try {
            return rm.obtenerRecursoPorTipo(tipo);
        }catch (Exception e){
            throw new PersistenceException("error al consultar los recursos:" + e.getLocalizedMessage(),e);
        }
    }

    @Override
    public List<recurso> loadByCapacity(int capacidad) throws PersistenceException{
        try {
            return rm.obtenerRecursoPorCapacidad(capacidad);
        }catch (Exception e){
            throw new PersistenceException("error al consultar los recursos:" + e.getLocalizedMessage(),e);
        }
    }

    @Override
    public List<recurso> loadByUbication(String ubicacion) throws PersistenceException {
        try {
            return rm.obtenerRecursoPorUbicacion(ubicacion);
        }catch (Exception e){
            throw new PersistenceException("error al consultar los recursos:" + e.getLocalizedMessage(),e);
        }
    }
}

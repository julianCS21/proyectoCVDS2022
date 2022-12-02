package biblioteca.backend.persistence.mybatisimpl;

import biblioteca.backend.entities.computador;
import biblioteca.backend.entities.libro;
import biblioteca.backend.entities.recurso;
import biblioteca.backend.entities.salaEstudio;
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

    @Override
    public void add(recurso r) throws PersistenceException {
        try{
            rm.añadirRecurso(r);
        }catch (Exception e){
            throw new PersistenceException("error al añadir  recurso:" + e.getLocalizedMessage(),e);
        }
    }

    @Override
    public libro loadBook(String nombreLibro) throws PersistenceException {
        try {
            return rm.consultarLibro(nombreLibro);
        } catch (Exception e) {
            throw new PersistenceException("error al consutlar libro:" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public computador loadPC(String nombreComputador) throws PersistenceException {
        try {
            return rm.consultarComputador(nombreComputador);
        } catch (Exception e) {
            throw new PersistenceException("error al consultar  computador:" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public salaEstudio loadStudyClass(String nombreSala) throws PersistenceException {
        try {
            return rm.consultarSalaEstudio(nombreSala);
        } catch (Exception e) {
            throw new PersistenceException("error al consultar  sala de estudio:" + e.getLocalizedMessage(), e);
        }
    }
}

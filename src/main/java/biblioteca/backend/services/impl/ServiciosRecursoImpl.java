package biblioteca.backend.services.impl;


import biblioteca.backend.entities.recurso;
import biblioteca.backend.persistence.DaoRecurso;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.services.ExcepcionServiciosRecurso;
import biblioteca.backend.services.ServiciosRecursos;
import com.google.inject.Inject;

import java.util.List;

public class ServiciosRecursoImpl  implements ServiciosRecursos {

    @Inject
    private DaoRecurso daoRecurso;


    @Override
    public List<recurso> obtenerRecurso() throws ExcepcionServiciosRecurso {
        try {
            return daoRecurso.loadAll();

        }catch (PersistenceException ex){
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);

        }
    }

    @Override
    public List<recurso> obtenerRecursoPorTipo(String tipo) throws  ExcepcionServiciosRecurso {
        try {
            return daoRecurso.loadByType(tipo);

        }catch (PersistenceException ex){
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);

        }
    }

    @Override
    public List<recurso> obtenerRecursoPorCapacidad(int capacidad) throws ExcepcionServiciosRecurso {
        try {
            return daoRecurso.loadByCapacity(capacidad);

        }catch (PersistenceException ex){
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);

        }
    }

    @Override
    public List<recurso> obtenerRecursoPorUbicacion(String ubicacion) throws ExcepcionServiciosRecurso {
        try {
            return daoRecurso.loadByUbication(ubicacion);

        }catch (PersistenceException ex){
            throw new ExcepcionServiciosRecurso("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);

        }
    }

    @Override
    public void añadirRecurso(recurso r) throws ExcepcionServiciosRecurso {
        try{
            daoRecurso.add(r);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosRecurso("Error al añadir :"+ex.getLocalizedMessage(), ex);

        }

    }
}

package biblioteca.backend.services.impl;

import biblioteca.backend.entities.usuario;
import biblioteca.backend.persistence.DaoUsuario;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.services.ExcepcionServiciosUsuario;
import biblioteca.backend.services.ServiciosUsuarios;

import javax.inject.Inject;

public class ServiciosUsuarioImpl implements ServiciosUsuarios {

    @Inject
    private DaoUsuario daoUsuario;

    @Override
    public usuario obtenerUsuarioxEmail(String correo) throws ExcepcionServiciosUsuario {
        try {
            return daoUsuario.loadbyEmail(correo);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosUsuario("Error al realizar la consulta:"+ex.getLocalizedMessage(), ex);
        }
    }
}

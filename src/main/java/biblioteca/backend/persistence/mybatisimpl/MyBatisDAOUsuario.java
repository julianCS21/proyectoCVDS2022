package biblioteca.backend.persistence.mybatisimpl;

import biblioteca.backend.entities.usuario;
import biblioteca.backend.persistence.DaoUsuario;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.persistence.mybatisimpl.mappers.usuarioMapper;
import com.google.inject.Inject;

import java.util.List;

public class MyBatisDAOUsuario implements DaoUsuario {

    @Inject
    private usuarioMapper um;

    @Override
    public usuario loadbyEmail(String correo) throws PersistenceException {
        try{
            return um.obtenerUsuarioxEmail(correo);
        } catch (Exception e){
            throw new PersistenceException("error al consultar los usuarios:" + e.getLocalizedMessage(),e);
        }
    }
}

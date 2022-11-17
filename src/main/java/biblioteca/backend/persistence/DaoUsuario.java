package biblioteca.backend.persistence;

import biblioteca.backend.entities.usuario;


public interface DaoUsuario {

    public usuario loadbyEmail(String correo) throws PersistenceException;
}

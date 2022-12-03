package biblioteca.backend.autenticacion;

import biblioteca.backend.persistence.PersistenceException;

import java.io.IOException;

public interface SessionLogger {




    public boolean isLogged();

    public void logout();

    boolean login(String correo, String contraseña) throws PersistenceException,IOException;
}
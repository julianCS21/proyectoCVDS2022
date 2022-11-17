package biblioteca.backend.autenticacion;

import biblioteca.backend.persistence.PersistenceException;

import java.io.IOException;

public interface SessionLogger {


    void login(String correo, String contraseña) throws PersistenceException, IOException;

    public boolean isLogged();

    public void logout();
}
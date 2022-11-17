package biblioteca.backend.services;

public class ExcepcionServiciosUsuario extends Exception{

    public ExcepcionServiciosUsuario() {
    }

    public ExcepcionServiciosUsuario(String message) {
        super(message);
    }

    public ExcepcionServiciosUsuario(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionServiciosUsuario(Throwable cause) {
        super(cause);
    }
}

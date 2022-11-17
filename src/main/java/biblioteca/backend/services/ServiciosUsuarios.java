package biblioteca.backend.services;

import biblioteca.backend.entities.recurso;
import biblioteca.backend.entities.usuario;

import java.util.List;

public interface ServiciosUsuarios {

    public usuario obtenerUsuarioxEmail(String correo) throws ExcepcionServiciosUsuario;

}

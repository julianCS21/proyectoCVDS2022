package biblioteca.backend.managedbeans;

import biblioteca.backend.entities.usuario;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.services.ExcepcionServiciosRecurso;
import biblioteca.backend.services.ExcepcionServiciosUsuario;
import biblioteca.backend.services.ServiciosUsuarios;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "usuario")

public class usuarioBean extends BasePageBean {

    private String correo;

    @Inject
    private ServiciosUsuarios su;

    public usuario obtenerUsuarioxEmail() throws PersistenceException{
        try{
            System.out.println(su.obtenerUsuarioxEmail(correo).toString());
            return su.obtenerUsuarioxEmail(correo);
        }catch (ExcepcionServiciosUsuario e){
            throw new PersistenceException("Error al buscar el usuario", e);
        }
    }

}

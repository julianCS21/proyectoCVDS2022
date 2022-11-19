package biblioteca.backend.managedbeans;

import biblioteca.backend.autenticacion.SessionLogger;
import biblioteca.backend.entities.usuario;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.services.ExcepcionServiciosRecurso;
import biblioteca.backend.services.ExcepcionServiciosUsuario;
import biblioteca.backend.services.ServiciosUsuarios;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@ManagedBean(name = "usuario")


@SessionScoped
public class usuarioBean extends BasePageBean {


    private String correo;

    private String contraseña;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public SessionLogger getSl() {
        return sl;
    }

    public void setSl(SessionLogger sl) {
        this.sl = sl;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ServiciosUsuarios getSu() {
        return su;
    }

    public void setSu(ServiciosUsuarios su) {
        this.su = su;
    }



    @Inject
    private ServiciosUsuarios su;

    @Inject
    private SessionLogger sl;

    public void login() throws PersistenceException, IOException {
        sl.login(correo,contraseña);
    }

}

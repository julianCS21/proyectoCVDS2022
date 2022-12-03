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







    @Inject
    private SessionLogger sl;

    public boolean isInicioSesion() {
        return inicioSesion;
    }

    public void setInicioSesion(boolean inicioSesion) {
        this.inicioSesion = inicioSesion;
    }

    private boolean inicioSesion = true;



    public void login() throws PersistenceException, IOException {
        setInicioSesion(sl.login(correo,contraseña));
    }


    public String verificarLogueo(){
        if(!inicioSesion){
            return "usuario o contraseña incorrecta,verifique los datos";
        }
        return "";
    }

}

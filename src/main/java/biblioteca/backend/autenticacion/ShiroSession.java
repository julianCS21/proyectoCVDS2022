package biblioteca.backend.autenticacion;


import biblioteca.backend.entities.usuario;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.services.ExcepcionServiciosUsuario;
import biblioteca.backend.services.ServiciosUsuarios;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.IOException;

public class ShiroSession  implements SessionLogger{

    @Inject
    private ServiciosUsuarios su;




    @Override
    public boolean login(String correo, String contraseña) throws PersistenceException, IOException {
        try {
            usuario us = su.obtenerUsuarioxEmail(correo);
            boolean vali = false;
            if(us != null){
                if(us.getContraseña().equals(contraseña)){
                    vali = true;
                }
            }
            if(vali){
                if(us.getRol().equals("administrador")){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrador.xhtml?faces-redirect=true");

                }
                else{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/usuario.xhtml?faces-redirect=true");
                }
                return true;
            }
            else{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml?faces-redirect=true&inicioSesion=false");

            }
        } catch (ExcepcionServiciosUsuario e) {
            throw new RuntimeException(e);
        }
        return false;
    }




        @Override
    public boolean isLogged() {
        return false;
    }

    @Override
    public void logout() {

    }
}

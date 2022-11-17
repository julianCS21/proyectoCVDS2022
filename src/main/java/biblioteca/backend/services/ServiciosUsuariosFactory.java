package biblioteca.backend.services;


import biblioteca.backend.entities.usuario;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import biblioteca.backend.persistence.DaoUsuario;
import biblioteca.backend.persistence.mybatisimpl.MyBatisDAOUsuario;
import biblioteca.backend.services.impl.ServiciosUsuarioImpl;

import javax.inject.Inject;


import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;


public class ServiciosUsuariosFactory {

    private static ServiciosUsuariosFactory instance = new ServiciosUsuariosFactory();

    private static Injector injector;
    //private static Injector testingInjector;

    private ServiciosUsuariosFactory() {
        injector = createInjector(new XMLMyBatisModule() {

                                      @Override
                                      protected void initialize() {
                                          install(JdbcHelper.MySQL);
                                          setClassPathResource("mybatis-config.xml");
                                          bind(ServiciosUsuarios.class).to(ServiciosUsuarioImpl.class);
                                          bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);

                                      }

                                  }
        );

        //testingInjector = createInjector(new XMLMyBatisModule() {

        //@Override
        //protected void initialize() {
        //install(JdbcHelper.MySQL);
        //setClassPathResource("mybatis-config-h2.xml");
        //bind(ServiciosPaciente.class).to(ServiciosPacienteImpl.class);
        //bind(DaoPaciente.class).to(MyBatisDAOPaciente.class);
        //}

        //}
        //);

    }

    public ServiciosUsuarios getForumsServices() {
        return injector.getInstance(ServiciosUsuarios.class);
    }

    //public ServiciosRecursos getTestingForumServices() {
    //return testingInjector.getInstance(ServiciosPaciente.class);
    //}

    public static ServiciosUsuariosFactory getInstance() {
        return instance;
    }

    public static void main(String a[]) throws ExcepcionServiciosUsuario {

    }

}

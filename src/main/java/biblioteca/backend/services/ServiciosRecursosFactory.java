package biblioteca.backend.services;


import biblioteca.backend.autenticacion.SessionLogger;
import biblioteca.backend.autenticacion.ShiroSession;
import biblioteca.backend.entities.recurso;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import biblioteca.backend.persistence.DaoRecurso;
import biblioteca.backend.persistence.mybatisimpl.MyBatisDAORecurso;
import biblioteca.backend.services.impl.ServiciosRecursoImpl;

import javax.inject.Inject;


import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;


public class ServiciosRecursosFactory {

    private static ServiciosRecursosFactory instance = new ServiciosRecursosFactory();

    private static Injector injector;
    //private static Injector testingInjector;

    private ServiciosRecursosFactory() {
        injector = createInjector(new XMLMyBatisModule() {

                                      @Override
                                      protected void initialize() {
                                          install(JdbcHelper.MySQL);
                                          setClassPathResource("mybatis-config.xml");
                                          bind(ServiciosRecursos.class).to(ServiciosRecursoImpl.class);
                                          bind(DaoRecurso.class).to(MyBatisDAORecurso.class);
                                          bind(SessionLogger.class).to(ShiroSession.class);

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

    public ServiciosRecursos getForumsServices() {
        return injector.getInstance(ServiciosRecursos.class);
    }

    //public ServiciosRecursos getTestingForumServices() {
    //return testingInjector.getInstance(ServiciosPaciente.class);
    //}

    public static ServiciosRecursosFactory getInstance() {
        return instance;
    }

    public static void main(String a[]) throws ExcepcionServiciosRecurso {

    }

}
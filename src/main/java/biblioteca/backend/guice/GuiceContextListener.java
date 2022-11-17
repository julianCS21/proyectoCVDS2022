package biblioteca.backend.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import biblioteca.backend.persistence.DaoRecurso;
import biblioteca.backend.persistence.DaoUsuario;
import biblioteca.backend.persistence.mybatisimpl.MyBatisDAORecurso;
import biblioteca.backend.persistence.mybatisimpl.MyBatisDAOUsuario;
import biblioteca.backend.services.ServiciosRecursos;
import biblioteca.backend.services.ServiciosUsuarios;
import biblioteca.backend.services.impl.ServiciosRecursoImpl;
import biblioteca.backend.services.impl.ServiciosUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {

                install(JdbcHelper.MySQL);

                setEnvironmentId("development");

                setClassPathResource("mybatis-config.xml");
                bind(ServiciosRecursos.class).to(ServiciosRecursoImpl.class);
                bind(DaoRecurso.class).to(MyBatisDAORecurso.class);

                bind(ServiciosUsuarios.class).to(ServiciosUsuarioImpl.class);
                bind(DaoUsuario.class).to(MyBatisDAOUsuario.class);



            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}
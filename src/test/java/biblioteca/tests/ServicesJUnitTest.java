package biblioteca.tests;

import biblioteca.backend.autenticacion.ShiroSession;
import biblioteca.backend.entities.recurso;
import biblioteca.backend.persistence.DaoRecurso;
import biblioteca.backend.persistence.PersistenceException;
import biblioteca.backend.persistence.mybatisimpl.MyBatisDAORecurso;
import biblioteca.backend.persistence.mybatisimpl.mappers.recursoMapper;
import biblioteca.backend.services.ExcepcionServiciosRecurso;
import biblioteca.backend.services.ServiciosRecursos;
import biblioteca.backend.services.ServiciosRecursosFactory;
import biblioteca.backend.services.impl.ServiciosRecursoImpl;
import com.google.inject.Inject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ServicesJUnitTest {

    public ServicesJUnitTest() {

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
    }

    @Test
    public void deberiaConsultarRecurso() throws SQLException, ExcepcionServiciosRecurso {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO RECURSOS (`id`, `nombre`, `ubicacion`, `tipo`, `capacidad`, `descripcion`, `disponible`) VALUES (1, 'ejemplo-nombre', 'ejemplo-ubicacion', 'ejemplo-tipo', 10, 'ejemplo-descripcion', 1)");
        conn.commit();
        conn.close();

        Assert.assertEquals(ServiciosRecursosFactory.getInstance().getForumsServices().obtenerRecurso().get(0).getId(), 1);
    }

    @Test
    public void deberiaRegistrarRecurso() throws SQLException, ExcepcionServiciosRecurso, PersistenceException {
        Connection conn = getConnection();
        recurso r = new recurso(1, "ejemplo-nombre", "ejemplo-ubicacion", "ejemplo-tipo", 10, "ejemplo-descripcion", 1);
        ServiciosRecursos sr = new ServiciosRecursos() {
            @Override
            public List<recurso> obtenerRecurso() throws ExcepcionServiciosRecurso {
                return null;
            }

            @Override
            public List<recurso> obtenerRecursoPorTipo(String tipo) throws ExcepcionServiciosRecurso {
                return null;
            }

            @Override
            public List<recurso> obtenerRecursoPorCapacidad(int capacidad) throws ExcepcionServiciosRecurso {
                return null;
            }

            @Override
            public List<recurso> obtenerRecursoPorUbicacion(String ubicacion) throws ExcepcionServiciosRecurso {
                return null;
            }

            @Override
            public void añadirRecurso(recurso r) throws ExcepcionServiciosRecurso {

            }
        };
        sr.añadirRecurso(r);
        conn.commit();
        conn.close();
        Assert.assertEquals(ServiciosRecursosFactory.getInstance().getForumsServices().obtenerRecurso().get(0).getId(), 1);
    }

    @Test
    public void deberiaIniciarSesion() {

    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        stmt.execute("delete from RECURSOS");
        conn.commit();
        conn.close();
    }

}

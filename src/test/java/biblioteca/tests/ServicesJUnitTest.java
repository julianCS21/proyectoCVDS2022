package biblioteca.tests;

import biblioteca.backend.autenticacion.SessionLogger;
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

import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ServicesJUnitTest {

    @Inject
    ServiciosRecursos sr;

    @Inject
    SessionLogger sl;




    public ServicesJUnitTest() {

    }

    @Before
    public void setUp() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
        Statement stmt = conn.createStatement();
        //stmt.execute ("CREATE TABLE RECURSOS (`id` int(11) NOT NULL AUTO_INCREMENT,`nombre` varchar(45) NOT NULL,`ubicacion` varchar(45) NOT NULL,`tipo` varchar(45) NOT NULL,`capacidad` int(11) NOT NULL,`descripcion` varchar(45) NOT NULL,`disponible` int(2) NOT NULL, PRIMARY KEY (`id`,`nombre`) ENGINE=InnoDB;");
        stmt.execute("CREATE TABLE USUARIOS (\n" +
                "\t`carnet` INT(7) NOT NULL,\n" +
                "\t`nombre` VARCHAR(50) NOT NULL ,\n" +
                "\t`correo` VARCHAR(50) NOT NULL ,\n" +
                "\t`contraseña` VARCHAR(15) NOT NULL,\n" +
                "\t`rol` VARCHAR(15) NOT NULL ,\n" +
                "\t`carrera` VARCHAR(50) NULL DEFAULT NULL,\n" +
                "\tPRIMARY KEY (`carnet`) USING BTREE,\n" +
                "\tUNIQUE INDEX `UK_correo` (`correo`) USING BTREE\n" +
                ")\n" +
                "ENGINE=InnoDB\n" +
                ";");
        conn.commit();
        conn.close();


    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "anonymous");
    }

    @Test
    public void DadoUnRecursoDeberiaConsultarRecurso() throws SQLException, ExcepcionServiciosRecurso {
        //arrange
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        //act
        stmt.execute("INSERT INTO RECURSOS (`id`, `nombre`, `ubicacion`, `tipo`, `capacidad`, `descripcion`, `disponible`) VALUES (1, 'ejemplo-nombre', 'ejemplo-ubicacion', 'ejemplo-tipo', 10, 'ejemplo-descripcion', 1)");
        conn.commit();
        conn.close();

        //assert
        Assert.assertEquals(ServiciosRecursosFactory.getInstance().getForumsServices().obtenerRecurso().get(0).getId(), 1);
    }

    @Test
    public void DadoUnRecursodeberiaRegistrarRecurso() throws SQLException, ExcepcionServiciosRecurso, PersistenceException {
        //arrange
        Connection conn = getConnection();
        recurso r = new recurso(10, "ejemplo-nombre", "ejemplo-ubicacion", "ejemplo-tipo", 10, "ejemplo-descripcion", 1);

        //act
        ServiciosRecursosFactory.getInstance().getForumsServices().añadirRecurso(r);
        conn.commit();
        conn.close();

        //assert
        Assert.assertEquals(ServiciosRecursosFactory.getInstance().getForumsServices().obtenerRecurso().get(9).getId(), 10);
    }

    @Test
    public void DadoUnEmailYUnaContraseñadeberiaIniciarSesion() throws SQLException, PersistenceException, IOException {
        //arrange
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();

        stmt.execute("INSERT INTO USUARIOS (`carnet`, `nombre`, `correo`, `contraseña`, `rol`, `carrera`) VALUES (2167317, 'ejemplo-nombre', 'ejemplo-correo@mail.escuelaing.edu.co','123', 'usuario', 'Ingenieria de sistemas')");

        //act
        boolean logueo = sl.login("ejemplo-correo@mail.escuelaing.edu.co","123");


        //assert
        Assert.assertTrue(logueo);

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

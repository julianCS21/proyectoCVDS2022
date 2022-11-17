package biblioteca.backend.persistence.mybatisimpl.mappers;

import biblioteca.backend.entities.recurso;
import biblioteca.backend.entities.usuario;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface usuarioMapper {

    public usuario obtenerUsuarioxEmail(@Param("correo") String correo);

}

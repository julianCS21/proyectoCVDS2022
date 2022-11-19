package biblioteca.backend.persistence.mybatisimpl.mappers;
import biblioteca.backend.entities.recurso;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface recursoMapper {


    public List<recurso> obtenerRecurso();


    public List<recurso> obtenerRecursoPorTipo(@Param("tipo") String tipo);


    public List<recurso> obtenerRecursoPorCapacidad(@Param("capacidad") int capacidad);

    public List<recurso> obtenerRecursoPorUbicacion(@Param("ubicacion") String ubicacion);

    public void añadirRecurso(@Param("recurso") recurso r);



}



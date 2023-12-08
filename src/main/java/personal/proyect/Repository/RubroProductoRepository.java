package personal.proyect.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.RubroProducto;

import java.util.List;

@Repository
public interface RubroProductoRepository extends BaseRepository<RubroProducto,Long>{

    @Query(
            value = "SELECT * FROM categoria_producto WHERE activo = true",
            nativeQuery = true)
    List<RubroProducto> findAllActivo();

}

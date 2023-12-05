package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.IngredienteReceta;

import java.util.List;

@Repository
public interface IngredienteRecetaRepository extends BaseRepository<IngredienteReceta,Long>{

    @Query(value = "SELECT i FROM IngredienteReceta i WHERE i.cantidadIR = :filtro")
    List<IngredienteReceta> search(int filtro );
    @Query(value = "SELECT i FROM IngredienteReceta i WHERE i.cantidadIR = :filtro")
    Page<IngredienteReceta> search(int filtro, Pageable pageable);

    //Anotación
    @Query(
            value = "SELECT * FROM ingredientereceta WHERE ingredientereceta.cantidadIR LIKE '%?1%'",
            nativeQuery = true
    )
    List<IngredienteReceta> searchNativo(int filtro);
    @Query(
            value = "SELECT * FROM ingredientereceta WHERE ingredientereceta.cantidadIR LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM ingredientereceta",
            nativeQuery = true
    )
    Page<IngredienteReceta> searchNativo(int filtro, Pageable pageable);

}

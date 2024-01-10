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

    //Anotación
    @Query(
            value = "SELECT * FROM Ingrediente_Receta WHERE cantidadIR = :filtro",
            countQuery = "SELECT count(*) FROM Ingrediente_Receta",
            nativeQuery = true
    )
    Page<IngredienteReceta> searchNativo(int filtro, Pageable pageable);

}

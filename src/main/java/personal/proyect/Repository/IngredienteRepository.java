package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Ingrediente;

import java.util.List;

@Repository
public interface IngredienteRepository extends BaseRepository<Ingrediente,Long>{

    @Query( value = "SELECT * FROM ingrediente WHERE (stock_actual <= stock_minimo) OR (stock_actual <= (stock_minimo + 0.2 * stock_minimo)) ",
            nativeQuery = true)
    Page<Ingrediente> bajoStock(Pageable pageable);

}

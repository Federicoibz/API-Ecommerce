package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.RubroIngrediente;

import java.util.List;

@Repository
public interface RubroIngredienteRepository extends BaseRepository<RubroIngrediente,Long>{

    List<RubroIngrediente> findByDenominacionContaining(String denominacion);

    Page<RubroIngrediente> findByDenominacionContaining(String denominacion, Pageable pageable);

    boolean existsByDenominacion(String denominacion);

    //Anotación
    @Query(
            value = "SELECT * FROM RubroIngrediente WHERE RubroIngrediente.denominacion LIKE '%?1%'",
            nativeQuery = true
    )
    List<RubroIngrediente> searchNativo(String filtro);
    @Query(
            value = "SELECT * FROM RubroIngrediente WHERE RubroIngrediente.denominacion LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM RubroIngrediente",
            nativeQuery = true
    )
    Page<RubroIngrediente> searchNativo(String filtro, Pageable pageable);

}

package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Receta;

@Repository
public interface RecetaRepository extends BaseRepository<Receta,Long>{

    boolean existsByNombreReceta(String nombreReceta);

    @Query(
            value = "SELECT * FROM Receta WHERE Receta.id LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM Receta",
            nativeQuery = true
    )Page<Receta> searchNativo(int filtro, Pageable pageable);

}

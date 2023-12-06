package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.UnidadMedida;

import java.util.List;

@Repository
public interface UnidadMedidaRepository extends BaseRepository<UnidadMedida,Long> {

    // Anotación método de Query
    List<UnidadMedida> findByDenominacionContaining(String denominacion);

    Page<UnidadMedida> findByDenominacionContaining(String denominacion, Pageable pageable);

    boolean existsByAbreviatura(String abreviatura);


    //Anotación JPQL parametros indexados
    @Query(value = "SELECT u FROM UnidadMedida u WHERE u.denominacion LIKE '%?1%'")
    List<UnidadMedida> search(String filtro);
    @Query(value = "SELECT u FROM UnidadMedida u WHERE u.denominacion LIKE '%?1%'")
    Page<UnidadMedida> search(String filtro, Pageable pageable);

    //Anotación
    @Query(
            value = "SELECT * FROM unidadmedida WHERE unidadmedida.denominacion LIKE '%?1%'",
            nativeQuery = true
    )
    List<UnidadMedida> searchNativo(String filtro);
    @Query(
            value = "SELECT * FROM unidadmedida WHERE unidadmedida.denominacion LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM unidadmedida",
            nativeQuery = true
    )
    Page<UnidadMedida> searchNativo(String filtro, Pageable pageable);



}

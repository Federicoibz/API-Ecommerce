package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Cliente;
import personal.proyect.Entities.Comprobante;

import java.util.List;

@Repository
public interface ComprobanteRepository extends BaseRepository<Comprobante,Long>{

    // Anotación método de Query
    List<Comprobante> findByNumeroComprobanteContaining(String numeroComprobante);

    Page<Comprobante> findByNumeroComprobanteContaining(String numeroComprobante, Pageable pageable);

    boolean existsByNumeroComprobante(String numeroComprobante);


    //Anotación JPQL parametros indexados
    @Query(value = "SELECT c FROM Comprobante c WHERE c.numeroComprobante =  :filtro")
    List<Comprobante> search(@Param("filtro")String numeroComprobante);
    @Query(value = "SELECT c FROM Comprobante c WHERE c.numeroComprobante LIKE '%?1%'")
    Page<Comprobante> search(String numeroComprobante, Pageable pageable);

    //Anotación
    @Query(
            value = "SELECT * FROM Comprobante WHERE numeroComprobante = 'filtro'",
            nativeQuery = true
    )
    List<Comprobante> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM Comprobante WHERE comprobante.numeroComprobante LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM Comprobante",
            nativeQuery = true
    )
    Page<Comprobante> searchNativo(String filtro, Pageable pageable);



}

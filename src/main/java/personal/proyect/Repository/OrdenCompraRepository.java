package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.OrdenCompra;

import java.util.List;

@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompra,Long>{

    //Anotación
    @Query(
            value = "SELECT * FROM OrdenCompra WHERE OrdenCompra.numOrdenCompra LIKE '%?1%'",
            nativeQuery = true
    )
    List<OrdenCompra> searchNativo(int filtro);
    @Query(
            value = "SELECT * FROM OrdenCompra WHERE OrdenCompra.numOrdenCompra LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM OrdenCompra",
            nativeQuery = true
    )
    Page<OrdenCompra> searchNativo(int filtro, Pageable pageable);

}



package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.OrdenCompra;


@Repository
public interface OrdenCompraRepository extends BaseRepository<OrdenCompra,Long>{

    //Anotación
    @Query(value = "SELECT * FROM OrdenCompra WHERE numOrdenCompra = ?1",
            countQuery = "SELECT count(*) FROM OrdenCompra WHERE numOrdenCompra = ?1",
            nativeQuery = true)

    Page<OrdenCompra> searchNativo(int filtro, Pageable pageable);

}



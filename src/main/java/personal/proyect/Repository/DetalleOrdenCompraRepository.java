package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.DetalleOrdenCompra;

import java.util.List;

@Repository
public interface DetalleOrdenCompraRepository extends BaseRepository<DetalleOrdenCompra,Long>{

    @Query(value = "SELECT * from DetalleOrdenCompra WHERE cantidadDetalleOrdenCompra = :filtro",
            nativeQuery = true)
    Page<DetalleOrdenCompra> searchCantidad(int filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM detalleOrdenCompra WHERE detalleOrdencompra.subtotal = :filtro",
            nativeQuery = true
    )
    Page<DetalleOrdenCompra> searchSubtotal(int filtro, Pageable pageable);

}

package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.DetalleOrdenCompra;

import java.util.List;

@Repository
public interface DetalleOrdenCompraRepository extends BaseRepository<DetalleOrdenCompra,Long>{

    @Query(value = "SELECT d from DetalleOrdenCompra d WHERE d.cantidadDetalleOrdenCompra = :filtro")
    List<DetalleOrdenCompra> search(int filtro);

    @Query(value = "SELECT d from DetalleOrdenCompra d WHERE d.cantidadDetalleOrdenCompra = :filtro")
    Page<DetalleOrdenCompra> search(int filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM detalleOrdenCompra WHERE detalleOrdencompra.subtotal LIKE '%?1%'",
            nativeQuery = true
    )
    List<DetalleOrdenCompra> searchNativo(int filtro);

    @Query(
            value = "SELECT * FROM detalleOrdenCompra WHERE detalleOrdencompra.subtotal LIKE '%?1%'",
            nativeQuery = true
    )
    Page<DetalleOrdenCompra> searchNativo(int filtro, Pageable pageable);

}

package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.DetalleFactura;

import java.util.List;

@Repository
public interface DetalleFacturaRepository extends BaseRepository<DetalleFactura,Long> {

    //List<DetalleFactura> findByCantidadContaining(int cantidad);
    //Page<DetalleFactura> findByCantidadContaining(int cantidad, Pageable pageable);

    //boolean existsBySubtotal(int subtotal);

    @Query(value = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :filtro")
    List<DetalleFactura> search(int filtro);
    @Query(value = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :filtro")
    Page<DetalleFactura> search(int filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM detalle_factura WHERE subtotal = :filtro",
            nativeQuery = true
    )
    List<DetalleFactura> searchNativo(int filtro);
    @Query(
            value = "SELECT * FROM detalle_factura WHERE subtotal = :filtro",
            countQuery = "SELECT count(*) FROM detallefactura",
            nativeQuery = true
    )
    Page<DetalleFactura> searchNativo(int filtro, Pageable pageable);
}

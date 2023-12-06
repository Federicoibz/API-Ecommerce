package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Producto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Producto,Long>{

    //query
    @Query(
            value = "SELECT * FROM Producto p WHERE p.denominacion LIKE %:filtro%",
            countQuery =  "SELECT count(*) FROM Producto p WHERE p.denominacion LIKE %:filtro%",
            nativeQuery = true
    )
    Page<Producto> searchByNombre(
            @Param("filtro") String filtro,
            Pageable pageable
    );


    @Query(
            value = "SELECT * FROM producto WHERE producto.descripcion LIKE %:filtro%",
            nativeQuery = true)
    public List<Producto> searchNative(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM Producto WHERE producto.precio_venta LIKE %:precioVenta%",
            nativeQuery = true
    )
    Page<Producto> searchByPrecioVenta(
            @Param("precioVenta") BigDecimal precioVenta,
            Pageable pageable
    );

    @Query(
            value = "SELECT * FROM Producto " +
                    "WHERE producto.precio_venta BETWEEN :precioMinimo AND :precioMaximo",
            nativeQuery = true
    )
    Page<Producto> searchByPrecioVentaRange(
            @Param("precioMinimo") BigDecimal precioMinimo,
            @Param("precioMaximo") BigDecimal precioMaximo,
            Pageable pageable
    );

    @Query(value = "SELECT p FROM Producto p JOIN RubroProducto r WHERE r.nombreCategoriaProducto LIKE %:nombreCategoria%")
    Page<Producto> searchByCategoriaNombre(
            @Param("nombreCategoria") String nombreCategoria,
            Pageable pageable
    );

    @Query(value = "SELECT p.DENOMINACION, p.URL_IMAGEN,SUM(d.cantidad) as totalVendido " +
            "FROM DETALLE_PEDIDO d " +
            "JOIN producto p WHERE d.id_producto = p.id " +
            "GROUP BY p.DENOMINACION, p.URL_IMAGEN " +
            "ORDER BY totalVendido DESC LIMIT 5", nativeQuery = true)
    List<Object[]> searchBestSelling(Date fechaInicio, Date fechaFin);
}



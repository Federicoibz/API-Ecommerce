package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Factura;

import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepository extends BaseRepository<Factura,Long>{

    @Query(value = "SELECT f FROM Factura f WHERE f.fechaFacturacion BETWEEN :fechaInicio AND :fechaFin")
    List<Factura> searchRango( @Param("fechaInicio") Date fechaInicio,
                               @Param("fechaFin") Date fechaFin);

    @Query(value = "SELECT f FROM Factura f WHERE f.fechaFacturacion BETWEEN :fechaInicio AND :fechaFin")
    Page<Factura> searchRango(@Param("fechaInicio") Date fechaInicio,
                              @Param("fechaFin") Date fechaFin,
                              Pageable pageable);


    @Query(value = "SELECT f FROM Factura f WHERE f.fechaFacturacion = :fechaFacturacion")
    List<Factura> searchFacturaByFechaFacturacion(@Param("fechaFacturacion") @DateTimeFormat Date fechaFacturacion);

    @Query(value = "SELECT f FROM Factura f WHERE f.fechaFacturacion = :fechaFacturacion")
    Page<Factura> searchFacturaByFechaFacturacion(@Param("fechaFacturacion") Date fechaFacturacion,
                                                  Pageable pageable);




}

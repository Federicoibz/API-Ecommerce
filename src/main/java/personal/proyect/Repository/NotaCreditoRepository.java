package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.NotaCredito;

import java.util.Date;

@Repository
public interface NotaCreditoRepository extends BaseRepository<NotaCredito,Long>{
    @Query(value = "SELECT f FROM NotaCredito f WHERE f.importeNC BETWEEN :rangoBase AND :rangoAlto")
    Page<NotaCredito> searchRangoImporteNC(@Param("rangoBase") int rangoBase,
                                           @Param("rangoAlto") int rangoAlto,
                                           Pageable pageable);

    @Query(value = "SELECT f FROM NotaCredito f WHERE f.importeNC = :importe ")
    Page<NotaCredito> searchImporteNC(@Param("importe") int importe,
                                      Pageable pageable);


    @Query(value = "SELECT f FROM NotaCredito f WHERE f.fechaNotaCredito = :fechaNotaCredito")
    Page<NotaCredito> searchNotaCredito(@Param("fechaNotaCredito") @DateTimeFormat Date fechaNotaCredito,
                                        Pageable pageable);

}

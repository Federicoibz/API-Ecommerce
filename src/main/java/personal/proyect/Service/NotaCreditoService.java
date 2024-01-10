package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.NotaCredito;

import java.util.Date;
import java.util.List;

@Service
public interface NotaCreditoService extends BaseService<NotaCredito,Long>{

    Page<NotaCredito> searchRangoImporteNC(@Param("rangoBase") int rangoBase,
                                           @Param("rangoAlto") int rangoAlto,
                                           Pageable pageable) throws Exception;

    Page<NotaCredito> searchImporteNC(@Param("importe") int importe,
                                      Pageable pageable) throws Exception;

    Page<NotaCredito> searchNotaCredito(@Param("fechaNotaCredito") @DateTimeFormat Date fechaNotaCredito,
                                        Pageable pageable)throws Exception;

}

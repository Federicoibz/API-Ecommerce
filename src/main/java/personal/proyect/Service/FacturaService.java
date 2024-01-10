package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Factura;

import java.util.Date;
import java.util.List;

@Service
public interface FacturaService extends BaseService<Factura,Long> {

    List<Factura> searchRango(Date fechaInicio, Date fechaFin)throws Exception;

    Page<Factura> searchRango(Date fechaInicio, Date fechaFin, Pageable pageable)throws Exception;

    List<Factura> searchFacturaByFechaFacturacion(Date fechaFacturacion) throws Exception;

    Page<Factura> searchFacturaByFechaFacturacion(Date fechaFacturacion,Pageable pageable) throws Exception;
}

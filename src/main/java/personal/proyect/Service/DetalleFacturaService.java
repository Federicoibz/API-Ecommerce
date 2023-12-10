package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.DetalleFactura;

import java.util.List;

@Service
public interface DetalleFacturaService extends BaseService<DetalleFactura,Long>{

    List<DetalleFactura> search(int filtro) throws Exception;

    Page<DetalleFactura> search(int filtro, Pageable pageable) throws Exception;
}

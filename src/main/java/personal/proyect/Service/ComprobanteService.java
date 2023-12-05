package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Comprobante;

import java.util.List;

@Service
public interface ComprobanteService extends BaseService<Comprobante,Long>{

    List<Comprobante> search(int filtro) throws Exception;

    Page<Comprobante> search(int filtro, Pageable pageable) throws Exception;
}

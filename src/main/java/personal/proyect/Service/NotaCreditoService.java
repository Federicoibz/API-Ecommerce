package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.NotaCredito;

import java.util.List;

@Service
public interface NotaCreditoService extends BaseService<NotaCredito,Long>{

    List<NotaCredito> search(String filtro)throws Exception;

    Page<NotaCredito> search(String filtro, Pageable pageable)throws Exception;

}

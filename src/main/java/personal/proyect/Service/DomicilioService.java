package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Domicilio;

import java.util.List;

@Service
public interface DomicilioService extends BaseService<Domicilio,Long>{

    List<Domicilio> search(String filtro)throws Exception;

    Page<Domicilio> search(String filtro,Pageable pageable) throws Exception;
}

package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Cliente;

import java.util.List;

@Service
public interface ClienteService extends BaseService<Cliente,Long>{

    List<Cliente> search(String filtro) throws Exception;
    Page<Cliente> search(String filtro, Pageable pageable) throws Exception;
}

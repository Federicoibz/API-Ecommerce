package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Localidad;

import java.util.List;

@Service
public interface LocalidadService extends BaseService<Localidad,Long> {

    List<Localidad> search(String filtro)throws Exception;

    Page<Localidad> search(String filtro, Pageable pageable)throws Exception;
}

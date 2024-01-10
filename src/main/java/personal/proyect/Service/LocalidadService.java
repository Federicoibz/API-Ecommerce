package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Localidad;

import java.util.List;

@Service
public interface LocalidadService extends BaseService<Localidad,Long> {

    Page<Localidad> searchCP(int filtro,Pageable pageable) throws Exception;

    Page<Localidad> searchNombre(String filtro, Pageable pageable)throws Exception;
}

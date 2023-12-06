package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Receta;

@Service
public interface RecetaService extends BaseService<Receta,Long>{

    Page<Receta> searchNativo(int filtro, Pageable pageable)throws Exception;

}

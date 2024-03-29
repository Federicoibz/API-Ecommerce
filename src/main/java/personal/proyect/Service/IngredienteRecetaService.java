package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.IngredienteReceta;

import java.util.List;

@Service
public interface IngredienteRecetaService extends BaseService<IngredienteReceta,Long>{

    Page<IngredienteReceta> search(int filtro, Pageable pageable) throws Exception;
}

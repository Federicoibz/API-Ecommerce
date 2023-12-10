package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Ingrediente;


@Service
public interface IngredienteService extends BaseService<Ingrediente,Long> {

    Page<Ingrediente> bajoStock(Pageable pageable) throws Exception;

}

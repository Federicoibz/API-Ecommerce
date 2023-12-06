package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.RubroIngrediente;

import java.util.List;

@Service
public interface RubroIngredienteService extends BaseService<RubroIngrediente,Long>{

    List<RubroIngrediente> searchNativo(String filtro)throws Exception;

    Page<RubroIngrediente> searchNativo(String filtro, Pageable pageable)throws Exception;

}

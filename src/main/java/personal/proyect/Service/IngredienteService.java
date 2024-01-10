package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Ingrediente;

import java.math.BigDecimal;


@Service
public interface IngredienteService extends BaseService<Ingrediente,Long> {

    Page<Ingrediente> bajoStock(BigDecimal stockMinimo, Pageable pageable) throws Exception;

    Page<Ingrediente> searchNombreNativo(String filtro, Pageable pageable)throws Exception;

}

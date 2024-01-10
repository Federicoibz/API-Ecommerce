package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.OrdenCompra;

import java.util.List;

@Service
public interface OrdenCompraService extends BaseService<OrdenCompra,Long>{

    Page<OrdenCompra> searchNativo(int filtro, Pageable pageable)throws Exception;

}

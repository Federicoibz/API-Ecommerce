package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.DetalleOrdenCompra;

import java.util.List;

@Service
public interface DetalleOrdenCompraService extends BaseService<DetalleOrdenCompra,Long>{

    Page<DetalleOrdenCompra> searchCantidad(int filtro,Pageable pageable) throws Exception;

    Page<DetalleOrdenCompra> searchSubtotal(int filtro,Pageable pageable) throws Exception;
}

package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.DetallePedido;

import java.util.List;

@Service
public interface DetallePedidoService extends BaseService<DetallePedido,Long>{

    List<DetallePedido> search(int filtro) throws Exception;

    Page<DetallePedido> search(int filtro, Pageable pageable) throws Exception;
}

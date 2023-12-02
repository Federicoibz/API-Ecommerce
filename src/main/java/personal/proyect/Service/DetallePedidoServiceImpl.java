package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.DetallePedido;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.DetallePedidoRepository;

public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallepedidoRepository;
    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallepedidoRepository) {
        super(baseRepository);
        this.detallepedidoRepository = detallepedidoRepository;
    }
}

package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.DetallePedido;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.DetallePedidoRepository;

import java.util.List;

@Service
public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallepedidoRepository;
    public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallepedidoRepository) {
        super(baseRepository);
        this.detallepedidoRepository = detallepedidoRepository;
    }

    @Override
    public List<DetallePedido> search(int filtro) throws Exception {
        try {
            List<DetallePedido> detallePedidos = detallepedidoRepository.searchNativo(filtro);
            return detallePedidos;
        }catch (Exception e){
                throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetallePedido> search(int filtro, Pageable pageable) throws Exception {
        try {
            Page<DetallePedido> detallePedidos = detallepedidoRepository.searchNativo(filtro,pageable);
            return detallePedidos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

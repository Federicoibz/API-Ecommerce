package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.DetalleOrdenCompra;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.DetalleOrdenCompraRepository;

import java.util.List;
@Service
public class DetalleOrdenCompraServiceImpl extends BaseServiceImpl<DetalleOrdenCompra, Long> implements DetalleOrdenCompraService{
    @Autowired
    private DetalleOrdenCompraRepository detalleordencompraRepository;
    public DetalleOrdenCompraServiceImpl(BaseRepository<DetalleOrdenCompra, Long> baseRepository, DetalleOrdenCompraRepository detalleordencompraRepository) {
        super(baseRepository);
        this.detalleordencompraRepository = detalleordencompraRepository;
    }

    @Override
    public List<DetalleOrdenCompra> search(int filtro) throws Exception {
        try {
            List<DetalleOrdenCompra> detalleOrdenCompras = detalleordencompraRepository.searchNativo(filtro);
            return detalleOrdenCompras;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleOrdenCompra> search(int filtro, Pageable pageable) throws Exception {
        try {
            Page<DetalleOrdenCompra> detalleOrdenCompras = detalleordencompraRepository.searchNativo(filtro,pageable);
            return detalleOrdenCompras;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

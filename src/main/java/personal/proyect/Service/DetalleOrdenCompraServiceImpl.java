package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import personal.proyect.Entities.DetalleOrdenCompra;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.DetalleOrdenCompraRepository;

import java.util.List;

public class DetalleOrdenCompraServiceImpl extends BaseServiceImpl<DetalleOrdenCompra, Long> implements DetalleOrdenCompraService{
    @Autowired
    private DetalleOrdenCompraRepository detalleordencompraRepository;
    public DetalleOrdenCompraServiceImpl(BaseRepository<DetalleOrdenCompra, Long> baseRepository, DetalleOrdenCompraRepository detalleordencompraRepository) {
        super(baseRepository);
        this.detalleordencompraRepository = detalleordencompraRepository;
    }
}

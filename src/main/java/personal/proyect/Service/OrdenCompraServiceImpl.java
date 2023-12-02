package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.OrdenCompra;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.OrdenCompraRepository;

public class OrdenCompraServiceImpl extends BaseServiceImpl<OrdenCompra,Long> implements OrdenCompraService {
    @Autowired
    private OrdenCompraRepository ordencompraRepository;
    public OrdenCompraServiceImpl(BaseRepository<OrdenCompra, Long> baseRepository, OrdenCompraRepository ordencompraRepository) {
        super(baseRepository);
        this.ordencompraRepository = ordencompraRepository;
    }
}

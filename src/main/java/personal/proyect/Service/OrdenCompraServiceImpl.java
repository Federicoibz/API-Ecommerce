package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.OrdenCompra;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.OrdenCompraRepository;

import java.util.List;

@Service
public class OrdenCompraServiceImpl extends BaseServiceImpl<OrdenCompra,Long> implements OrdenCompraService {
    @Autowired
    private OrdenCompraRepository ordencompraRepository;
    public OrdenCompraServiceImpl(BaseRepository<OrdenCompra, Long> baseRepository, OrdenCompraRepository ordencompraRepository) {
        super(baseRepository);
        this.ordencompraRepository = ordencompraRepository;
    }

    @Override
    public Page<OrdenCompra> searchNativo(int filtro, Pageable pageable) throws Exception {
        try {
            Page<OrdenCompra> ordenCompras = ordencompraRepository.searchNativo(filtro,pageable);
            return ordenCompras;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

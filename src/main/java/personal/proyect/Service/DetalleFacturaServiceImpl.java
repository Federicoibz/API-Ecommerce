package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.DetalleFactura;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.DetalleFacturaRepository;

import java.util.List;

@Service
public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura,Long> implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detallefacturaRepository;
    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository, DetalleFacturaRepository detallefacturaRepository) {
        super(baseRepository);
        this.detallefacturaRepository = detallefacturaRepository;
    }

    @Override
    public List<DetalleFactura> search(int filtro) throws Exception{
        try {
            List<DetalleFactura> detalleFacturas = detallefacturaRepository.searchNativo(filtro);
            return detalleFacturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleFactura> search(int filtro, Pageable pageable) throws Exception{
        try{
          Page<DetalleFactura> detalleFacturas = detallefacturaRepository.searchNativo(filtro, pageable);
          return  detalleFacturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DetalleFactura> searchCantidad(int filtro) throws Exception{
        try {
            List<DetalleFactura> detalleFacturas = detallefacturaRepository.search(filtro);
            return detalleFacturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<DetalleFactura> searchCantidad(int filtro, Pageable pageable) throws Exception{
        try{
            Page<DetalleFactura> detalleFacturas = detallefacturaRepository.search(filtro, pageable);
            return  detalleFacturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.DetalleFactura;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.DetalleFacturaRepository;


public class DetalleFacturaServiceImpl extends BaseServiceImpl<DetalleFactura,Long> implements DetalleFacturaService {
    @Autowired
    private DetalleFacturaRepository detallefacturaRepository;
    public DetalleFacturaServiceImpl(BaseRepository<DetalleFactura, Long> baseRepository, DetalleFacturaRepository detallefacturaRepository) {
        super(baseRepository);
        this.detallefacturaRepository = detallefacturaRepository;
    }
}

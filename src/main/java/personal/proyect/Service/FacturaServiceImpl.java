package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.Factura;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.FacturaRepository;

public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }
}

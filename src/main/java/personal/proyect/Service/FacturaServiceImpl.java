package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Factura;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.FacturaRepository;

import java.util.Date;
import java.util.List;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository, FacturaRepository facturaRepository) {
        super(baseRepository);
        this.facturaRepository = facturaRepository;
    }

    @Override
    public List<Factura> searchRango(Date fechaInicio, Date fechaFin) throws Exception {
        try {
            List<Factura> facturas = facturaRepository.searchRango(fechaInicio,fechaFin);
            return facturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Factura> searchRango(Date fechaInicio, Date fechaFin, Pageable pageable) throws Exception {
    try {
        Page<Factura> facturas = facturaRepository.searchRango(fechaInicio,fechaFin,pageable);
        return facturas;
    }catch (Exception e){
        throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Factura> search(Date fechaFacturacion) throws Exception {
        try {
            List<Factura> facturas = facturaRepository.search(fechaFacturacion);
            return facturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Factura> search(Date fechaFacturacion,Pageable pageable) throws Exception {
        try {
            Page<Factura> facturas = facturaRepository.search(fechaFacturacion,pageable);
            return facturas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}

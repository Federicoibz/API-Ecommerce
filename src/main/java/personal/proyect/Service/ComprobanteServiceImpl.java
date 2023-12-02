package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.Comprobante;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.ComprobanteRepository;

import java.util.List;

public class ComprobanteServiceImpl extends BaseServiceImpl<Comprobante,Long> implements ComprobanteService{
    @Autowired
    private ComprobanteRepository comprobanteRepository;
    public ComprobanteServiceImpl(BaseRepository<Comprobante, Long> baseRepository, ComprobanteRepository comprobanteRepository) {
        super(baseRepository);
        this.comprobanteRepository = comprobanteRepository;
    }
}

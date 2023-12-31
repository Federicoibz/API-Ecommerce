package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Comprobante;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.ComprobanteRepository;

import java.util.List;
@Service
public class ComprobanteServiceImpl extends BaseServiceImpl<Comprobante,Long> implements ComprobanteService{
    @Autowired
    private ComprobanteRepository comprobanteRepository;
    public ComprobanteServiceImpl(BaseRepository<Comprobante, Long> baseRepository, ComprobanteRepository comprobanteRepository) {
        super(baseRepository);
        this.comprobanteRepository = comprobanteRepository;
    }

    @Override
    public List<Comprobante> search(String filtro) throws Exception {
        try {
            List<Comprobante> comprobantes = comprobanteRepository.search(filtro);

            return comprobantes;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public Page<Comprobante> search(String filtro, Pageable pageable) throws Exception{
        try {
            Page<Comprobante> comprobantes = comprobanteRepository.search(filtro, pageable);
            return comprobantes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}

package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.NotaCredito;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.NotaCreditoRepository;

import java.util.List;

@Service
public class NotaCreditoServiceImpl extends BaseServiceImpl<NotaCredito,Long> implements NotaCreditoService{
    @Autowired
    private NotaCreditoRepository notacreditoRepository;
    public NotaCreditoServiceImpl(BaseRepository<NotaCredito, Long> baseRepository, NotaCreditoRepository notacreditoRepository) {
        super(baseRepository);
        this.notacreditoRepository = notacreditoRepository;
    }

    @Override
    public List<NotaCredito> search(String filtro) throws Exception {
        try {
            List<NotaCredito> notaCreditos = notacreditoRepository.searchNativo(filtro);
            return notaCreditos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<NotaCredito> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<NotaCredito> notaCreditos = notacreditoRepository.searchNativo(filtro,pageable);
            return notaCreditos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

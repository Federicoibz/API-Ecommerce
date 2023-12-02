package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.NotaCredito;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.NotaCreditoRepository;

public class NotaCreditoServiceImpl extends BaseServiceImpl<NotaCredito,Long> implements NotaCreditoService{
    @Autowired
    private NotaCreditoRepository notacreditoRepository;
    public NotaCreditoServiceImpl(BaseRepository<NotaCredito, Long> baseRepository, NotaCreditoRepository notacreditoRepository) {
        super(baseRepository);
        this.notacreditoRepository = notacreditoRepository;
    }
}

package personal.proyect.Service;


import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.Domicilio;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.DomicilioRepository;

public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }
}

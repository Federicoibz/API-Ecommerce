package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Localidad;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.LocalidadRepository;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;
    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository, LocalidadRepository localidadRepository) {
        super(baseRepository);
        this.localidadRepository = localidadRepository;
    }

    @Override
    public Page<Localidad> searchCP(int filtro,Pageable pageable) throws Exception {
        try {
            Page<Localidad> localidades = localidadRepository.searchCP(filtro,pageable);
            return localidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Localidad> searchNombre(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Localidad> localidades = localidadRepository.searchNombre(filtro,pageable);
            return localidades;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

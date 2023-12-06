package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Receta;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.RecetaRepository;

@Service
public class RecetaServiceImpl extends BaseServiceImpl<Receta,Long> implements RecetaService {
    @Autowired
    private RecetaRepository recetaRepository;
    public RecetaServiceImpl(BaseRepository<Receta, Long> baseRepository, RecetaRepository recetaRepository) {
        super(baseRepository);
        this.recetaRepository = recetaRepository;
    }

    @Override
    public Page<Receta> searchNativo(int filtro, Pageable pageable) throws Exception {
        try {
            Page<Receta> recetas = recetaRepository.searchNativo(filtro,pageable);
            return recetas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

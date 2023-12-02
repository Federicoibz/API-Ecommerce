package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.Receta;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.RecetaRepository;

public class RecetaServiceImpl extends BaseServiceImpl<Receta,Long> implements RecetaService {
    @Autowired
    private RecetaRepository recetaRepository;
    public RecetaServiceImpl(BaseRepository<Receta, Long> baseRepository, RecetaRepository recetaRepository) {
        super(baseRepository);
        this.recetaRepository = recetaRepository;
    }
}

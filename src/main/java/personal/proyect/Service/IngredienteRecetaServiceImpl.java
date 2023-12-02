package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.IngredienteReceta;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.IngredienteRecetaRepository;

public class IngredienteRecetaServiceImpl extends BaseServiceImpl<IngredienteReceta, Long> implements IngredienteRecetaService {

    @Autowired
    private IngredienteRecetaRepository ingredienterecetaRepository;
    public IngredienteRecetaServiceImpl(BaseRepository<IngredienteReceta, Long> baseRepository, IngredienteRecetaRepository ingredienterecetaRepository) {
        super(baseRepository);
        this.ingredienterecetaRepository = ingredienterecetaRepository;
    }
}

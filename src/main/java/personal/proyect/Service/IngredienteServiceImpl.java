package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.Ingrediente;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.IngredienteRepository;

public class IngredienteServiceImpl extends BaseServiceImpl<Ingrediente, Long> implements IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;
    public IngredienteServiceImpl(BaseRepository<Ingrediente, Long> baseRepository, IngredienteRepository ingredienteRepository) {
        super(baseRepository);
        this.ingredienteRepository = ingredienteRepository;
    }
}

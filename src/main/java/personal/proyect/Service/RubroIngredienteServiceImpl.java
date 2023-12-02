package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.RubroIngrediente;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.RubroIngredienteRepository;

public class RubroIngredienteServiceImpl extends BaseServiceImpl<RubroIngrediente, Long> implements RubroIngredienteService {

    @Autowired
    private RubroIngredienteRepository rubroingredienteRepository;
    public RubroIngredienteServiceImpl(BaseRepository<RubroIngrediente, Long> baseRepository, RubroIngredienteRepository rubroingredienteRepository) {
        super(baseRepository);
        this.rubroingredienteRepository = rubroingredienteRepository;
    }
}

package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.RubroIngrediente;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.RubroIngredienteRepository;

import java.util.List;

@Service
public class RubroIngredienteServiceImpl extends BaseServiceImpl<RubroIngrediente, Long> implements RubroIngredienteService {

    @Autowired
    private RubroIngredienteRepository rubroingredienteRepository;
    public RubroIngredienteServiceImpl(BaseRepository<RubroIngrediente, Long> baseRepository, RubroIngredienteRepository rubroingredienteRepository) {
        super(baseRepository);
        this.rubroingredienteRepository = rubroingredienteRepository;
    }

    @Override
    public List<RubroIngrediente> searchNativo(String filtro) throws Exception {
        try {
            List<RubroIngrediente> rubroIngredientes = rubroingredienteRepository.searchNativo(filtro);
            return rubroIngredientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<RubroIngrediente> searchNativo(String filtro, Pageable pageable) throws Exception {
        try {
            Page<RubroIngrediente> rubroIngredientes = rubroingredienteRepository.searchNativo(filtro,pageable);
            return rubroIngredientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

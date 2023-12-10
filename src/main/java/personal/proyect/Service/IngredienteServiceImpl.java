package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Ingrediente;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.IngredienteRepository;

@Service
public class IngredienteServiceImpl extends BaseServiceImpl<Ingrediente, Long> implements IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;
    public IngredienteServiceImpl(BaseRepository<Ingrediente, Long> baseRepository, IngredienteRepository ingredienteRepository) {
        super(baseRepository);
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public Page<Ingrediente> bajoStock(Pageable pageable) throws Exception {
        try {
            Page<Ingrediente> ingredientes = ingredienteRepository.bajoStock(pageable);
            return  ingredientes;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

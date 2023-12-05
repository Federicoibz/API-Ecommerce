package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.IngredienteReceta;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.IngredienteRecetaRepository;

import java.util.List;

@Service
public class IngredienteRecetaServiceImpl extends BaseServiceImpl<IngredienteReceta, Long> implements IngredienteRecetaService {

    @Autowired
    private IngredienteRecetaRepository ingredienterecetaRepository;
    public IngredienteRecetaServiceImpl(BaseRepository<IngredienteReceta, Long> baseRepository, IngredienteRecetaRepository ingredienterecetaRepository) {
        super(baseRepository);
        this.ingredienterecetaRepository = ingredienterecetaRepository;
    }

    @Override
    public List<IngredienteReceta> search(int filtro) throws Exception {
        try{
            List<IngredienteReceta> ingredienteRecetas = ingredienterecetaRepository.searchNativo(filtro);
            return ingredienteRecetas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<IngredienteReceta> search(int filtro, Pageable pageable) throws Exception {
        try {
            Page<IngredienteReceta> ingredienteRecetas = ingredienterecetaRepository.searchNativo(filtro, pageable);
            return ingredienteRecetas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
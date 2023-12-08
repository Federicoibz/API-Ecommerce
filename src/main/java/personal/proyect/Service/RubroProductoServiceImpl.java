package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.RubroProducto;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.RubroProductoRepository;

import java.util.List;

@Service
public class RubroProductoServiceImpl extends BaseServiceImpl<RubroProducto, Long> implements RubroProductoService{

    @Autowired
    private RubroProductoRepository rubroproductoRepository;
    public RubroProductoServiceImpl(BaseRepository<RubroProducto, Long> baseRepository, RubroProductoRepository rubroproductoaRepository) {
        super(baseRepository);
        this.rubroproductoRepository = rubroproductoRepository;
    }

    @Override
    public List<RubroProducto> search(String filtro) throws Exception {
        return null;
    }

    @Override
    public Page<RubroProducto> search(String filtro, Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public List<RubroProducto> findAllActivo() throws Exception {
        try {
            List<RubroProducto> rubroProductos = rubroproductoRepository.findAllActivo();
            return rubroProductos;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}

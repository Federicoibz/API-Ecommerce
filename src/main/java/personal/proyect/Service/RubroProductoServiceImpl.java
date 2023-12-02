package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.RubroProducto;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.RubroProductoRepository;

public class RubroProductoServiceImpl extends BaseServiceImpl<RubroProducto, Long> implements RubroProductoService{

    @Autowired
    private RubroProductoRepository rubroproductoRepository;
    public RubroProductoServiceImpl(BaseRepository<RubroProducto, Long> baseRepository, RubroProductoRepository rubroproductoaRepository) {
        super(baseRepository);
        this.rubroproductoRepository = rubroproductoRepository;
    }
}

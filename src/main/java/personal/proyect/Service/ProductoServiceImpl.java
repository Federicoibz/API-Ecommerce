package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.proyect.Entities.Producto;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.ProductoRepository;

public class ProductoServiceImpl extends BaseServiceImpl<Producto, Long> implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;
    public ProductoServiceImpl(BaseRepository<Producto, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }
}

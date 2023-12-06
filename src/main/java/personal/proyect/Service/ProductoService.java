package personal.proyect.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.DTOs.DTOProductosMasVendidos;
import personal.proyect.Entities.Producto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public interface ProductoService extends BaseService<Producto,Long>{

    public List<Producto> search (String filtro) throws Exception;
    Page<Producto> searchByNombre(String filtro, Pageable pageable) throws Exception;

    Page<Producto> searchByPrecioVenta(BigDecimal precioVenta, Pageable pageable) throws Exception;

    Page<Producto> searchByPrecioVentaRange(BigDecimal precioMinimo, BigDecimal precioMaximo, Pageable pageable) throws Exception;

    Page<Producto> searchByCategoriaNombre(String nombreCategoria, Pageable pageable) throws Exception;

    List<DTOProductosMasVendidos> searchBestSelling(Date fechaInicio, Date fechaFin) throws Exception;

}

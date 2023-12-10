package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.DTOs.DTOProductosMasVendidos;
import personal.proyect.Entities.Producto;
import personal.proyect.Service.ProductoServiceImpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/Producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>{

    @GetMapping(path = "/search")
    public ResponseEntity<?> search (@RequestParam String filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \""+e.getMessage());
        }
    }
    @GetMapping("/searchByNombre")
    public ResponseEntity<?> searchByNombre(@RequestParam String filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByNombre(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchByPrecioVenta")
    public ResponseEntity<?> searchByPrecioVenta(@RequestParam BigDecimal precioVenta, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByPrecioVenta(precioVenta, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchByPrecioVentaRange")
    public ResponseEntity<?> searchByPrecioVentaRange(@RequestParam BigDecimal precioMinimo, @RequestParam BigDecimal precioMaximo, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByPrecioVentaRange(precioMinimo, precioMaximo, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchByCategoriaNombre")
    public ResponseEntity<?> searchByCategoriaNombre(@RequestParam String nombreCategoria, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByCategoriaNombre(nombreCategoria, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/searchBestSelling")
    public ResponseEntity<?> searchBestSelling(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        try {
            List<DTOProductosMasVendidos> productos = servicio.searchBestSelling(fechaInicio, fechaFin);
            return ResponseEntity.status(HttpStatus.OK).body(productos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }

    }

}

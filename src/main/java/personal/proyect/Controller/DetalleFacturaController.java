package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.DetalleFactura;
import personal.proyect.Service.DetalleFacturaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/DetalleFactura")
public class DetalleFacturaController extends BaseControllerImpl<DetalleFactura, DetalleFacturaServiceImpl> {

    @GetMapping(path = "/search")
    public ResponseEntity<?> searchNativo(@RequestParam int filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchPaged")
    public ResponseEntity<?> searchNativo(@RequestParam int filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchCantidad")
    public ResponseEntity<?> search(@RequestParam int filtro){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchCantidad(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchCantidadPaged")
    public ResponseEntity<?> search(@RequestParam int filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchCantidad(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}

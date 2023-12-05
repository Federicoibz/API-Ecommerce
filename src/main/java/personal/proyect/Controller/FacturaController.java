package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.Factura;
import personal.proyect.Service.FacturaServiceImpl;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/Factura")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{

    @GetMapping(path = "/search")
    public ResponseEntity<?> search(@RequestParam Date fechaInicio,@RequestParam Date fechaFin) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchRango(fechaInicio,fechaFin));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchPaged")
    public ResponseEntity<?> search(@RequestParam Date fechaInicio,@RequestParam Date fechaFin, Pageable pageable) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchRango(fechaInicio,fechaFin,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}

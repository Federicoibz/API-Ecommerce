package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.Domicilio;
import personal.proyect.Service.DomicilioServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/Domicilio")
public class DomicilioController extends BaseControllerImpl<Domicilio,DomicilioServiceImpl> {

    @GetMapping(path = "/search")
    public ResponseEntity<?> search(@RequestParam String filtro) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}

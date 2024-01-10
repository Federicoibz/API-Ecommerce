package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.Localidad;
import personal.proyect.Service.LocalidadServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/Localidad")
public class LocalidadController extends  BaseControllerImpl<Localidad, LocalidadServiceImpl>{

    @GetMapping(path = "/searchCPPaged")
    public ResponseEntity<?> searchCP(@RequestParam int filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchCP(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchNombrePaged")
    public ResponseEntity<?> searchNombre(@RequestParam String filtro, Pageable pageable){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNombre(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}

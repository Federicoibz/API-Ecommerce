package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.Receta;
import personal.proyect.Service.RecetaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/Receta")
public class RecetaController extends BaseControllerImpl<Receta, RecetaServiceImpl> {

    @GetMapping(path = "/searchPaged")
    public ResponseEntity<?> search(@RequestParam int filtro, Pageable pageable)throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativo(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}

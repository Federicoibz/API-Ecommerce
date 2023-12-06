package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.proyect.Entities.RubroIngrediente;
import personal.proyect.Service.RubroIngredienteServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/RubroIngrediente")
public class RubroIngredienteController extends BaseControllerImpl<RubroIngrediente, RubroIngredienteServiceImpl> {

    @GetMapping(path = "/search")
    public ResponseEntity<?> search(String filtro)throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativo(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchPaged")
    public ResponseEntity<?> search(String filtro, Pageable pageable)throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativo(filtro,pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}

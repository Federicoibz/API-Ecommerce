package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.proyect.Entities.Ingrediente;
import personal.proyect.Service.IngredienteServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.co/Ingrediente")
public class IngredienteController extends BaseControllerImpl<Ingrediente, IngredienteServiceImpl>{

    @GetMapping("/bajoStock")
    public ResponseEntity<?> bajoStock(String denominacion) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.bajoStock(Pageable.unpaged()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}

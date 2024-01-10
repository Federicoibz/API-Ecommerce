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

import java.math.BigDecimal;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.co/Ingrediente")
public class IngredienteController extends BaseControllerImpl<Ingrediente, IngredienteServiceImpl>{

    @GetMapping("/bajoStock")
    public ResponseEntity<?> bajoStock(BigDecimal stockMinimo, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.bajoStock(stockMinimo,pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchNombre")
    public ResponseEntity<?> searchNombreNativo(String filtro,Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNombreNativo(filtro,pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}

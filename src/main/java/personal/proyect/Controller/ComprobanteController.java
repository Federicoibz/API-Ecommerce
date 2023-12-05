package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.Comprobante;
import personal.proyect.Service.ComprobanteServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/Comprobante")
public class ComprobanteController extends BaseControllerImpl<Comprobante, ComprobanteServiceImpl>{

    @GetMapping(path = "/search")
        public ResponseEntity<?> searchNativo(@RequestParam int filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
        @GetMapping("/searchPaged")
        public ResponseEntity<?> search(@RequestParam int filtro, Pageable pageable) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
            }
        }
    }



package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.NotaCredito;
import personal.proyect.Service.NotaCreditoServiceImpl;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/NotaCredito")
public class NotaCreditoController extends BaseControllerImpl<NotaCredito, NotaCreditoServiceImpl>{

    @GetMapping(path = "/searchRangoImporteNC")
    public ResponseEntity<?> search(@RequestParam int rangoBase,
                                    @RequestParam int rangoAlto,
                                    @RequestParam Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchRangoImporteNC(rangoBase,rangoAlto,pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/searchImporteNC")
    public ResponseEntity<?> search(@RequestParam int importe,
                                    @RequestParam Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchImporteNC(importe, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

        @GetMapping("/searchNotaCredito")
        public ResponseEntity<?> search(@RequestParam Date fechaNotaCredito, Pageable pageable) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNotaCredito(fechaNotaCredito, pageable));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
            }
    }
}


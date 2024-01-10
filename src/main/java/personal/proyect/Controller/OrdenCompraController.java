package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.OrdenCompra;
import personal.proyect.Service.OrdenCompraServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/OrdenCompra")
public class OrdenCompraController extends BaseControllerImpl<OrdenCompra, OrdenCompraServiceImpl>{

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam int filtro, Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchNativo(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

}

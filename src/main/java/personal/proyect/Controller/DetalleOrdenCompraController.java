package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.proyect.Entities.DetalleOrdenCompra;
import personal.proyect.Service.DetalleOrdenCompraServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/DetalleOrdenCompra")
public class DetalleOrdenCompraController extends BaseControllerImpl<DetalleOrdenCompra, DetalleOrdenCompraServiceImpl>{

    @GetMapping(path = "/search")
    public ResponseEntity<?> search(int filtro)throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping(path = "/searchPaged")
    public ResponseEntity<?> search(int filtro, Pageable pageable) throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

}

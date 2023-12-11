package personal.proyect.Controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.Cliente;
import personal.proyect.Service.ClienteServiceImpl;

//es un controlador para manejar solicitudes http y automaticamente serializa los objetos retorno en JSON
@RestController
//permite el origen cruzado de las solicitudes http si estan alojados (el front y back) en distintas plataformas
@CrossOrigin(origins = "*")
//especifica la url para los endpoints
@RequestMapping(path = "api/v1/u.ca/Cliente")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

    //maneja las solicitudes http GET para el endpoint /searchByName
    @GetMapping("/searchByName")
    //toma el parametro filtro de la query y retorna un responseEntity
    public ResponseEntity<?> searchNativo(@RequestParam String filtro) {
        try {
            //el metodo invoca el metodo search de servicio y retorna el resultado con un codigo de estado http
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    //maneja las solicitudes http GET para el endpoint /searchPaged
    @GetMapping("/searchPaged")
    //toma el parametro filtro y pageable de la query y retorna un responseEntity
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable) {
        try {
            //el metodo invoca el metodo search de servicio y retorna el resultado paginado con un codigo de estado http
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
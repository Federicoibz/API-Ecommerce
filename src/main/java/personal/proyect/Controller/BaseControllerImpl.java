package personal.proyect.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.proyect.Entities.Base;
import personal.proyect.Service.BaseServiceImpl;

import org.springframework.data.domain.Pageable;


//clase abstracta para controladores
//utiliza los tipos genericos E y S
public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {

    //@Autowired --> para la inyeccion de dependencias
    @Autowired
    protected S servicio;

    //implementacion de todos los metodos que tengo en la interfaz BaseController
    // Anotación que mapea una solicitud HTTP GET a la URL especificada, en este caso, la ruta raíz ("/"). Esto significa que este método se ejecutará cuando se realice una solicitud GET a la ruta raíz.
    @GetMapping("")
    //retorna un objeto ResponseEntity que representa toda la respuesta http
    public ResponseEntity<?> getAll(){
        try{
            System.out.println("Estoy en el controller");
            // devuelve una ResponseEntity con un código de estado OK (200) y el cuerpo de la respuesta es el resultado de llamar al método findAll() del servicio.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());
        }catch(Exception e){
            //Si ocurre una excepción (capturada por el bloque catch), se devuelve una ResponseEntity con un código de estado NOT_FOUND (404) y un cuerpo JSON que contiene un mensaje de error genérico.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }
    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try{
            // devuelve una ResponseEntity con un código de estado OK (200) y el cuerpo de la respuesta es el resultado de llamar al método findAll(pageable) del servicio.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));
        }catch(Exception e){
            //Si ocurre una excepción (capturada por el bloque catch), se devuelve una ResponseEntity con un código de estado NOT_FOUND (404) y un cuerpo JSON que contiene un mensaje de error genérico.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){
        try{
            // devuelve una ResponseEntity con un código de estado OK (200) y el cuerpo de la respuesta es el resultado de llamar al método findById(id) del servicio.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));
        }catch (Exception e){
            //Si ocurre una excepción (capturada por el bloque catch), se devuelve una ResponseEntity con un código de estado NOT_FOUND (404) y un cuerpo JSON que contiene un mensaje de error genérico.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    //mapea una solicitud HTTP POST a la URL
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){
        try{
            System.out.println(entity);
            // devuelve una ResponseEntity con un código de estado OK (200) y el cuerpo de la respuesta es el resultado de llamar al método save(entity) del servicio.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        } catch (Exception e){
            //Si ocurre una excepción (capturada por el bloque catch), se devuelve una ResponseEntity con un código de estado NOT_FOUND (404) y un cuerpo JSON que contiene un mensaje de error genérico.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    //manejará las solicitudes HTTP PUT para la ruta especificada, donde {id} es un marcador de posición para un identificador único.
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody E entity){
        try{
            // devuelve una ResponseEntity con un código de estado OK (200) y el cuerpo de la respuesta es el resultado de llamar al método update(id, entity) del servicio.
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
        } catch(Exception e) {
            //Si ocurre una excepción (capturada por el bloque catch), se devuelve una ResponseEntity con un código de estado NOT_FOUND (404) y un cuerpo JSON que contiene un mensaje de error genérico.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }

    //manejará las solicitudes HTTP DELETE para la ruta especificada, donde {id} es un marcador de posición para un identificador único.
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            // devuelve una ResponseEntity con un código de estado OK (200) y el cuerpo de la respuesta es el resultado de llamar al método delete() del servicio.
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch(Exception e) {
            //Si ocurre una excepción (capturada por el bloque catch), se devuelve una ResponseEntity con un código de estado NOT_FOUND (404) y un cuerpo JSON que contiene un mensaje de error genérico.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente mas tarde.\"}");
        }
    }
}
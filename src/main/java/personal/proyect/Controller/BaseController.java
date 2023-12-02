package personal.proyect.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import personal.proyect.Entities.Base;

import java.awt.print.Pageable;
import java.io.Serializable;

//interfaz generica
// Utiliza tipos genéricos E e ID, donde E extiende de la clase Base y ID es Serializable
public interface BaseController<E extends Base, ID extends Serializable> {

    //metodo para devolver todos los elementos
    //devuelve un responseEntity sin tipo especifico (?)
    // ResponseEntity --> encapsula todos los detalles de una respuesta HTTP, incluyendo el cuerpo, las cabeceras y el código de estado.
    //  |-->  devolver cualquier tipo de objeto como el cuerpo de la respuesta, ya que está parametrizado por el tipo del cuerpo (<T>). Esto significa que puedes devolver objetos complejos, listas, cadenas, etc.
    //  |-->  especifica el código de estado que se enviará en la respuesta.
    //  |-->  agregar cabeceras personalizadas a la respuesta, como encabezados de autenticación, de tipo de contenido, etc
    public ResponseEntity<?> getAll();

    public ResponseEntity<?> getAll(Pageable pageable);

    //metodo para obterner un elemento por su id
    //@PathVariable --> mapea el ID desde la URL (ruta/id.123 --> devuelve un responseEntity de id 123)
    public ResponseEntity<?> getOne(@PathVariable ID id);

    //guarda un elemento
    // @RequestBody --> mapea la entidad desde el cuerpo de la solicitud
    public ResponseEntity<?> save(@RequestBody E entity);

    //metodo para actualizar un elemento por su id
    // pathVariable --> busca el id
    // requestBody  --> mapea la entidad
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);

    //metodo para borrar una entidad por su id
    //pathvariable --> para el id
    public ResponseEntity<?> delete(@PathVariable ID id);
}

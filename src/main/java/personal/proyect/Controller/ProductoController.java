package personal.proyect.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.proyect.Entities.Producto;
import personal.proyect.Service.ProductoServiceImpl;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/u.ca/Producto")
public class ProductoController extends BaseControllerImpl<Producto, ProductoServiceImpl>{
}

package personal.proyect.Service;

import org.springframework.stereotype.Service;
import personal.proyect.Entities.Usuario;

import java.util.List;

@Service
public interface UsuarioService extends BaseService<Usuario,Long>{

    List<Usuario> search(String filtro) throws Exception;

}

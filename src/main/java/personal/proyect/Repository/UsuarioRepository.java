package personal.proyect.Repository;

import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario,Long> {
}

package personal.proyect.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Base;

import java.io.Serializable;

@Repository
@NoRepositoryBean
//para que el repositorio no se instancie
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
    //<E extends Base, ID extends Serializable>--> limita los tipos de datos que se le pueden pasar

}

package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Domicilio;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long>{

    @Query(value = "select d from Domicilio d WHERE d.nombreCalle LIKE %:filtro%")
    List<Domicilio> search(String filtro);

    @Query(value = "select d from Domicilio d WHERE d.nombreCalle LIKE %:filtro%")
    Page<Domicilio> search(String filtro, Pageable pageable);

    @Query(
            value = "select * from Domicilio WHERE nombreCalle like '%1%'",
            nativeQuery = true
    )List<Domicilio> searchNativo(String filtro);

    @Query(
            value = "select * from Domicilio WHERE nombreCalle like '%1%'",
            nativeQuery = true
    )Page<Domicilio> searchNativo(String filtro,Pageable pageable);

}

package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Localidad;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad,Long>{

    //Anotación
    @Query(
            value = "SELECT * FROM localidad WHERE codigo_Postal = :filtro",
            nativeQuery = true
    )
    Page<Localidad> searchCP(int filtro,Pageable pageable);
    @Query(
            value = "SELECT * FROM localidad WHERE nombre_Localidad LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNombre(String filtro, Pageable pageable);



}

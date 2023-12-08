package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Cliente;

import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{
    // Anotación método de Query
    List<Cliente> findByApellidoContaining(String apellido);

    Page<Cliente> findByApellidoContaining(String apellido, Pageable pageable);

    boolean existsByApellido(String apellido);


    //Anotación JPQL parametros indexados
    @Query(value = "SELECT c FROM Cliente c WHERE c.apellido LIKE %:filtro%")
    List<Cliente> search(@Param("filtro")String filtro);
    @Query(value = "SELECT c FROM Cliente c WHERE c.apellido LIKE '%?1%'")
    Page<Cliente> search(String filtro, Pageable pageable);

    //Anotación
    @Query(
            value = "SELECT * FROM Cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
            nativeQuery = true
    )
    List<Cliente> searchNativo(@Param("filtro") String filtro);
    @Query(
            value = "SELECT * FROM cliente WHERE cliente.nombre LIKE %:filtro% OR cliente.apellido LIKE %:filtro% ",
            countQuery = "SELECT count(*) FROM cliente",
            nativeQuery = true
    )
    Page<Cliente> searchNativo(String filtro, Pageable pageable);


}

package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.DetallePedido;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido,Long>{

    @Query(value = "SELECT d from DetallePedido d WHERE d.cantidad = :filtro")
    List<DetallePedido> search(int filtro);

    @Query(value = "SELECT d from DetallePedido d WHERE d.cantidad = :filtro")
    Page<DetallePedido> search(int filtro, Pageable pageable);

    @Query(
            value = "select * from DetallePedido WHERE cantidad = :filtro",
            nativeQuery = true
    )List<DetallePedido> searchNativo(int filtro);

    @Query(
            value = "select * from DetallePedido WHERE cantidad = :filtro",
            nativeQuery = true
    )Page<DetallePedido> searchNativo(int filtro, Pageable pageable);


}

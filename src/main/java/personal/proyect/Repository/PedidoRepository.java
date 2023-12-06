package personal.proyect.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import personal.proyect.Entities.Pedido;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido,Long> {

    @Query(
            value = "SELECT * FROM Pedido WHERE estado = :estado",
            countQuery = "SELECT count(*) FROM Pedido WHERE estado = 'PREPARACION'",
            nativeQuery = true
    )
    Page<Pedido> searchstatus(@Param("estado") String estado, Pageable pageable);

    boolean existsByFechaPedido(Date fechaPedido);

    //Anotación
    @Query(
            value = "SELECT * FROM Pedido WHERE Pedido.fechaPedido LIKE '%?1%'",
            nativeQuery = true
    )
    List<Pedido> searchNativo(Date filtro);

    @Query(
            value = "SELECT * FROM Pedido WHERE Pedido.fechaPedido LIKE '%?1%'",
            countQuery = "SELECT count(*) FROM Pedido",
            nativeQuery = true
    )
    Page<Pedido> searchNativo(Date filtro, Pageable pageable);

    //HU 16
    @Query(
            value = "SELECT * FROM Pedido WHERE Pedido.estado = 'EN_CAMINO'",
            nativeQuery = true
    )
    List<Pedido> pedidoDelivery();

    //US 14

    @Query(
            value = "SELECT * FROM Pedido WHERE Pedido.estado = :filtroc ",
            nativeQuery = true
    )
    List<Pedido> searchCajero(@Param("filtroc") String filtroc);

    //US 15
    @Modifying
    @Query(
            value = "UPDATE Pedido SET estado = :cambio WHERE estado = 'A_CONFIRMAR'",
            nativeQuery = true
    )
    void cambioCajero(@Param("cambio") String cambio);



    @Modifying
    @Query(
            value = "UPDATE Pedido SET estado = :cambio WHERE estado = 'LISTO' and EstadoPedido = 'PAGADO'",
            nativeQuery = true
    )
    void entregaCajero(@Param("cambio") String cambio);

    //US 16
    @Query(
            value = "SELECT c.nombre, c.apellido, c.telefono, d.calle, d.numero FROM Pedido p " +
                    "JOIN Domicilio d ON p.domicilio.id = d.id " +
                    "JOIN Cliente c ON p.cliente.id = c.id " +
                    "WHERE p.estado = 'EN_CAMINO'",
            nativeQuery = true
    )
    List<Object[]> searchDelivery();

    @Modifying
    @Query(
            value = "UPDATE Pedido SET estado = 'COMPLETADO' ",
            nativeQuery = true
    )
    void entregaDelivery();


    @Query(
            value = "SELECT p.id, p.total, p.fecha_pedido, p.estado, p.estado_pago, p.tipo_envio, " +
                    "p.forma_pago FROM Pedido p JOIN Cliente c ON p.id_cliente = c.id " +
                    "JOIN Usuario u ON c.id_usuario = u.id WHERE u.id = :id ",
            nativeQuery = true
    )
    List <Object[]> searchPedidos(@Param("id")Long id);


}

package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import personal.proyect.Enums.EstadoPagoPedido;
import personal.proyect.Enums.EstadoPedido;
import personal.proyect.Enums.FormaPago;
import personal.proyect.Enums.TipoEnvio;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido extends Base {

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;

    @NotNull
    @Column(name = "total", precision = 10, scale = 2)
    private BigDecimal total;

    @NotNull
    @Column(name = "total_costo", precision = 10, scale = 2)
    private BigDecimal totalCosto;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;


    @NotNull
    @Column(name = "estado_pago")
    @Enumerated(EnumType.STRING)
    private EstadoPagoPedido estadoPago;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @ManyToOne()
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @NotNull
    @OneToMany
    @JoinColumn(name="id_detalle_pedido")
    private List<DetallePedido> detallePedido;

}

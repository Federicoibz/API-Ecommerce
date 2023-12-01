package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "DetalleFactura")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleFactura extends Base{

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @Column(name = "subtotal", precision = 10, scale = 2)
    private BigDecimal subtotal;

    @ManyToOne()
    @JoinColumn(name = "id_comprobante")
    private Comprobante comprobante;
}

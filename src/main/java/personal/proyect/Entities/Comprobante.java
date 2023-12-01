package personal.proyect.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Comprobante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comprobante extends Base{

    @Column(name = "fechaFacturacion")
    private Date fechaFacturacionComprobante;

    @Column(name = "nombreComprobante")
    private String nombreComprobante;

    @NotNull
    @Column(name = "numeroComprobante")
    private String numeroComprobante;

    @NotNull
    @Column(name = "totalComprobante", precision = 10, scale = 2)
    private BigDecimal totalComprobante;
}

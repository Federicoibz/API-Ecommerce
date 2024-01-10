package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "OrdenCompra")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class OrdenCompra extends Comprobante{

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaHoraOrdenCompra")
    private Date fechaHoraOrdenCompra;

    @NotNull
    @Column(name = "montoTotalOrdenCompra")
    private double montoTotalOrdenCompra;

    @NotNull
    @Column(name = "numOrdenCompra")
    private int numOrdenCompra;
}

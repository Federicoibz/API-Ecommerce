package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "NotaCredito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotaCredito extends Comprobante  {

    @NotNull
    @Column(name = "Fecha_Nota_Credito")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNotaCredito;

    @Column(name = "Importe")
    private double importeNC;

    @Column(name = "Descripción")
    private String descripcionNC;

}
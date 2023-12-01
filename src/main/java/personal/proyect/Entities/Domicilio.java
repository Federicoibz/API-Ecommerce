package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio extends Base{

    @NotNull
    @Column(name = "calle", length = 500)
    private String calle;

    @NotNull
    @Column(name = "numero", precision = 5)
    private Integer numero;

    @Column(name = "numero_vivienda")
    private Integer numeroDpto;

    @Column(name = "piso_vivienda")
    private Integer pisoDpto;

    @ManyToOne()
    @JoinColumn(name = "id_localidad")
    private Localidad localidad;
}

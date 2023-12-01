package personal.proyect.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "UnidadMedida")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UnidadMedida extends Base{

    @NotNull
    @Column(name = "denominacion", length = 255)
    private String denominacion;

    @NotNull
    @Column(name = "abreviatura", length = 25)
    private String abreviatura;

}

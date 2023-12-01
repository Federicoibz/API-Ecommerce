package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "IngredienteReceta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IngredienteReceta extends Base{

    @NotNull
    @Column(name = "cantidadIR")
    private int cantidadIR;

    @ManyToOne()
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;
}

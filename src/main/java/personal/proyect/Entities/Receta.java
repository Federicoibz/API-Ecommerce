package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Receta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receta extends Base{

    @NotNull
    @Column(name = "nombreReceta")
    private String nombreReceta;

    @NotNull
    @Column(name = "instruccion")
    private String instruccion;

    @Column(name = "duracionReceta")
    private int duracionReceta;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_ingrediente_receta")
    private IngredienteReceta ingredienteReceta;
}

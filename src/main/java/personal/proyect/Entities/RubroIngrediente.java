package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "RubroIngrediente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RubroIngrediente extends Base {

    @NotNull
    @Column(name = "denominacion")
    private String denominacion;

    @ManyToOne()
    @JoinColumn(name = "id_rubro_padre")
    private RubroIngrediente rubroPadre;

    @OneToMany(mappedBy = "rubroPadre")
    private List<RubroIngrediente> subRubros;

    public RubroIngrediente(String denominacion, RubroIngrediente rubroPadre) {
        this.denominacion = denominacion;
        this.rubroPadre = rubroPadre;
    }

    public void setSubRubros(List<RubroIngrediente> subRubros) {
        this.subRubros.clear();
        this.subRubros.addAll(subRubros);
    }
}

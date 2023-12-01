package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingrediente extends Base{

    @NotNull
    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "url_imagen")
    private String urlImagen;

    @NotNull
    @Column(name = "precio_compra", precision = 10, scale = 2)
    private BigDecimal precioCompra;

    @NotNull
    @Column(name = "stock_actual", precision = 10, scale = 2)
    private BigDecimal stockActual;

    @NotNull
    @Column(name = "stock_minimo", precision = 10, scale = 2)
    private BigDecimal stockMinimo;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_unidad_medida")
    private UnidadMedida unidadMedida;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "id_rubro_articulo")
    private RubroIngrediente rubroIngrediente;

}

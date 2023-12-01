package personal.proyect.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Producto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Producto extends Base{

    @NotNull
    @Column(name = "denominacion")
    private String denominacion;

    @NotNull
    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private Integer tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta", precision = 10, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Receta receta;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_rubro_producto")
    private RubroProducto rubroProducto;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name= "id_detalle_factura")
    private List<DetalleFactura> detallesfactura = new ArrayList<DetalleFactura>();

}

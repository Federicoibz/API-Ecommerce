package personal.proyect.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RubroProducto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RubroProducto extends Base{

    @Column(name = "descripcionCategoriaProducto")
    private String descripcionCategoriaProducto;

    @Column(name = "nombreCategoriaProducto")
    private String nombreCategoriaProducto;
}

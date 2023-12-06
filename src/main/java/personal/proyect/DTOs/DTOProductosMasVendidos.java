package personal.proyect.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DTOProductosMasVendidos {
    private String denominacion;
    private String urlImagen;
    private Long totalVendido;

    public DTOProductosMasVendidos(String denominacion, String urlImagen, Long totalVendido) {
        this.denominacion = denominacion;
        this.urlImagen = urlImagen;
        this.totalVendido = totalVendido;
    }
    public DTOProductosMasVendidos() {
    }
}

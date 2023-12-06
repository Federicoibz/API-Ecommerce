package personal.proyect.DTOs;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString
public class DTOPedido {
    Long id;
    BigDecimal total;
    String fechaPedido;
    String estado;
    String estadoPago;
    String tipoEnvio;
    String formaPago;

    public DTOPedido(Long id, BigDecimal total, String fechaPedido, String estado, String estadoPago
            , String tipoEnvio, String formaPago) {
        this.id = id;
        this.total = total;
        this.fechaPedido = fechaPedido;
        this.estado = estado.replaceAll(Pattern.quote(String.valueOf("_"))," ");
        this.estadoPago = estadoPago.replaceAll(Pattern.quote(String.valueOf("_"))," ");
        this.tipoEnvio = tipoEnvio.replaceAll(Pattern.quote(String.valueOf("_"))," ");
        this.formaPago = formaPago.replaceAll(Pattern.quote(String.valueOf("_"))," ");
    }
    public DTOPedido() {
    }
}
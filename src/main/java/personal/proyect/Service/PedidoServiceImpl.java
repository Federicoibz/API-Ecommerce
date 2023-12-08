package personal.proyect.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.DTOs.DTOPedido;
import personal.proyect.Entities.Pedido;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.PedidoRepository;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> search(Date filtro) throws Exception {
        try {
            List<Pedido> pedido = pedidoRepository.searchNativo(filtro);

            return pedido;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public Page<Pedido> searchstatus(String estado, Pageable pageable) throws Exception {
        try {
            Page<Pedido> pedido = pedidoRepository.searchstatus(estado, pageable);

            return pedido;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    public Page<Pedido> search(Date filtro, Pageable pageable) throws Exception {
        try {
            Page<Pedido> pedido = pedidoRepository.searchNativo(filtro, pageable);

            return pedido;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Pedido> pedidoDelivery() throws Exception {
        try {
            List<Pedido> pedido = pedidoRepository.pedidoDelivery();
            return pedido;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Pedido> searchCajero(String filtro ) throws Exception {
        try {
            List<Pedido> pedido = pedidoRepository.searchCajero(filtro );

            return pedido;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public void cambioCajero(Long id, String cambio) throws Exception {
        try {
            // Realiza la operación de actualización llamando al método en el repositorio
            pedidoRepository.cambioCajero(cambio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional

    public void entregaCajero(Long id,String cambio ) throws Exception {
        try {
            pedidoRepository.entregaCajero(cambio);


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    public List<Object[]> searchDelivery() throws Exception {
        try {
            List<Object[]> Object = pedidoRepository.searchDelivery();

            return Object;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Transactional
    public void entregaDelivery(Long id) throws Exception {
        try {
            pedidoRepository.entregaDelivery();


        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Object searchPedidos(Long id) throws Exception {
        try {
            List<Object[]> results = pedidoRepository.searchPedidos(id);
            List<DTOPedido> dtos = new ArrayList<>();

            for (Object[] result : results) {
                Long nro = (Long) result[0];
                BigDecimal total = (BigDecimal) result[1];
                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                String fechaPedido = formato.format(result[2]);
                String estado = (String) result[3];
                String estadoPago = (String) result[4];
                String tipoEnvio = (String) result[5];
                String formaPago = (String) result[6];
                dtos.add(new DTOPedido(nro, total, fechaPedido, estado, estadoPago, tipoEnvio,formaPago));
            }
            return dtos;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}

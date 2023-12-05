package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Cliente;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.ClienteRepository;

import java.util.List;


@Service

public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> search(String filtro) throws Exception {
        try {
            //List<Cliente> clientes = clienteRepository.findByDenominacionContaining(filtro, filtro);
            //List<Cliente> clientes = clienteRepository.search(filtro);
            List<Cliente> clientes = clienteRepository.searchNativo(filtro);

            return clientes;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Cliente> search(String filtro, Pageable pageable) throws Exception {
        try {
            //Page<Cliente> clientes = clienteRepository.findByDenominacionContaining(filtro, filtro, pageable);
            //Page<Cliente> clientes = clienteRepository.search(filtro, pageable);
            Page<Cliente> cliente = clienteRepository.searchNativo(filtro, pageable);

            return cliente;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return null;
    }
}
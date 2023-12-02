package personal.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.proyect.Entities.Cliente;
import personal.proyect.Repository.BaseRepository;
import personal.proyect.Repository.ClienteRepository;


public class ClienteServiceImpl extends BaseServiceImpl<Cliente,Long> implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente,Long> baseRepository, ClienteRepository clienteRepository){
        super(baseRepository);
        this.clienteRepository = clienteRepository;

    }
}

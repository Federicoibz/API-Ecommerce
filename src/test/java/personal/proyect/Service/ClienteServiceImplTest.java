package personal.proyect.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import personal.proyect.Entities.Cliente;
import personal.proyect.Repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ClienteServiceImplTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteServiceImpl clienteService;

    @Test
    void testSearchString() throws Exception{

        Cliente cliente = new Cliente();
        cliente.setNombre("fede");
        cliente.setApellido("ibanez");

        List<Cliente> listEnviada = new ArrayList<>();
        listEnviada.add(cliente);

        when(clienteRepository.searchNativo("fede")).thenReturn(listEnviada);

        assertEquals(listEnviada,clienteService.search("fede"));
    }

}

package personal.proyect.Repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import personal.proyect.Entities.Cliente;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class ClienteRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void testSearchString() {
        Cliente cliente = new Cliente();
        cliente.setNombre("fede");
        cliente.setApellido("ibanez");

        List<Cliente> listEnviada = new ArrayList<>();
        listEnviada.add(cliente);

        entityManager.persist(cliente);
        entityManager.flush();

        assertEquals(listEnviada,clienteRepository.searchNativo("fede"));
        assertEquals(listEnviada,clienteRepository.searchNativo("ibanez"));

    }
}

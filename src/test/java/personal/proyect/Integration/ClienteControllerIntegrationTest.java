package personal.proyect.Integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import personal.proyect.Entities.Cliente;
import personal.proyect.ProyectApplication;
import personal.proyect.Repository.ClienteRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = ProyectApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties"
)
class ClienteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void testSearchString() throws Exception {

        Cliente cliente = new Cliente();
        cliente.setNombre("fede");
        cliente.setApellido("ibanez");

        clienteRepository.save(cliente);

        mockMvc.perform(get("/api/v1/u.ca/Cliente/searchByName")
                        .param("filtro","fede")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("fede")))
                .andExpect(jsonPath("$[0].apellido", is("ibanez")));


    }

    }

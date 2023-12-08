package personal.proyect.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import personal.proyect.Entities.Cliente;
import personal.proyect.Service.ClienteServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @MockBean
    private ClienteServiceImpl clienteService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSearchString() throws Exception{

        Cliente cliente = new Cliente();
        cliente.setNombre("fede");
        cliente.setApellido("ibanez");

        List<Cliente> listEnviada = new ArrayList<>();
        listEnviada.add(cliente);

        when(clienteService.search("fede")).thenReturn(listEnviada);

        mockMvc.perform(get("/api/v1/u.ca/Cliente/searchByName")
                        .param("filtro","fede")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre", is("fede")))
                .andExpect(jsonPath("$[0].apellido", is("ibanez")));

    }

}

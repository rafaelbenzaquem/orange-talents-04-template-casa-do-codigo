package br.com.zup.academy.benzaquem.casadocodigo.estado;

import br.com.zup.academy.benzaquem.casadocodigo.pais.Pais;
import br.com.zup.academy.benzaquem.casadocodigo.pais.PaisRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.platform.engine.discovery.UriSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EstadosControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PaisRepository paisRepository;

    @Test
    @Order(1)
    public void estadoCadastradoComSucessoRetorna200() throws Exception{
        Pais pais = new Pais(null,"Estados Unidos");
        pais = paisRepository.save(pais);

        String requestBody = "{" +
                "\"nome\":\"Texas\"," +
                "\"pais\":"+pais.getId()+
                "}";

        String responseBody = "{" +
                "\"id\":1,"+
                "\"nome\":\"Texas\"," +
                "\"pais\":"+pais.getId()+
                "}";

        URI uri = new URI("/estados");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcResultMatchers.content().json(responseBody));

    }

    @Test
    @Order(2)
    public void estadoComPaisInexistenteRetorna400() throws Exception{

        String requestBody = "{" +
                "\"nome\":\"California\"," +
                "\"pais\": 99"+
                "}";

        URI uri = new URI("/estados");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));

    }

    @Test
    @Order(3)
    public void estadoComNomeIgualParaMesmoPaisRetorna400() throws Exception{

        String requestBody = "{" +
                "\"nome\":\"Texas\"," +
                "\"pais\":1"+
                "}";

        URI uri = new URI("/estados");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
    }

}

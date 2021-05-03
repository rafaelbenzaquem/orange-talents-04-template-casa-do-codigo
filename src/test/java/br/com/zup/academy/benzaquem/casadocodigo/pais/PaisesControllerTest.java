package br.com.zup.academy.benzaquem.casadocodigo.pais;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
public class PaisesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void paisCadastradoComSucessoRetorna200() throws Exception{
        String requestBody = "{ " +
                "\"nome\":\"Brasil\"" +
                "}";
        String responseBody= "{ " +
                "\"id\":1,"+
                "\"nome\":\"Brasil\"" +
                "}";
        URI uri = new URI("/paises");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestBody))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andExpect(MockMvcResultMatchers.content().json(responseBody));

    }
    @Test
    @Order(1)
    public void paisComNomeExistenteRetorna400() throws Exception{
        String requestBody = "{ " +
                "\"nome\":\"Brasil\"" +
                "}";

        URI uri = new URI("/paises");

        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));

    }

}

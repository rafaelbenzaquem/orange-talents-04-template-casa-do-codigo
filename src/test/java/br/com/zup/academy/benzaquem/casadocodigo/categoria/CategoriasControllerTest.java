package br.com.zup.academy.benzaquem.casadocodigo.categoria;

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
public class CategoriasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void categoriaCadastradaComSucessoRetorna200() throws Exception {
        URI uri = new URI("/categorias");
        String request = "{" +
                "\"nome\":\"Programação\"" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()));

    }

    @Test
    @Order(2)
    public void categoriaComNomeDuplicadoRetorna400() throws Exception {
        URI uri = new URI("/categorias");
        String request = "{" +
                "\"nome\":\"Programação\"" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));

    }

    @Test
    public void categoriaComNomeVazioOuNuloRetorna400() throws Exception {
        URI uri = new URI("/categorias");
        String request = "{" +
                "\"nome\":\" \"" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        ).andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));

    }


}

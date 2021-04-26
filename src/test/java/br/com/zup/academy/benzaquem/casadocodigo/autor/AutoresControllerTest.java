package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
public class AutoresControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void autorCriadoComSucessoRetorna200() throws Exception {
        URI uri = new URI("/autores");
        String body = "{\n" +
                "\"nome\":\"Rafael Benzaquem Neto\",\n" +
                "\"email\":\"rafael.neto@zup.com.br\",\n" +
                "\"descricao\":\"autor de teste\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(200)
                );
    }

}

package br.com.zup.academy.benzaquem.casadocodigo.autor;

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
public class AutoresControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void autorCadastradoComSucessoRetorna200() throws Exception {
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
                        .status().is(HttpStatus.OK.value())
                )
                .andExpect(MockMvcResultMatchers
                        .content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    @Order(2)
    public void autorComEmailDuplicadoRetorna400() throws Exception {
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
                        .status().is(HttpStatus.BAD_REQUEST.value())
                );
    }



    @Test
    public void autorComNomeNuloOuVazioRetorna400() throws Exception {
        URI uri = new URI("/autores");
        String body = "{\n" +
                "\"nome\":\" \",\n" +
                "\"email\":\"rafael.neto@zup.com.br\",\n" +
                "\"descricao\":\"autor de teste\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(HttpStatus.BAD_REQUEST.value())
                );
    }

    @Test
    public void autorComEmailNuloOuVazioRetorna400() throws Exception {
        URI uri = new URI("/autores");
        String body = "{\n" +
                "\"nome\":\"Rafael Benzaquem Neto \",\n" +
                "\"email\":\" \",\n" +
                "\"descricao\":\"autor de teste\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(HttpStatus.BAD_REQUEST.value())
                );
    }

    @Test
    public void autorComEmailMalFormatadoRetorna400() throws Exception {
        URI uri = new URI("/autores");
        String body = "{\n" +
                "\"nome\":\"Rafael Benzaquem Neto \",\n" +
                "\"email\":\" asldkjasdasdjlkas\",\n" +
                "\"descricao\":\"autor de teste\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(HttpStatus.BAD_REQUEST.value())
                );
    }

    @Test
    public void autorComDescricaoNulaOuVaziaRetorna400() throws Exception {
        URI uri = new URI("/autores");
        String body = "{\n" +
                "\"nome\":\"Rafael Benzaquem Neto \",\n" +
                "\"email\":\"rafael.neto@zup.com\",\n" +
                "\"descricao\":\"\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(HttpStatus.BAD_REQUEST.value())
                );
    }

    @Test
    public void autorComDescricaoComMaisDe400CaracteresRetorna400() throws Exception {
        URI uri = new URI("/autores");
        String body = "{\n" +
                "\"nome\":\"Rafael Benzaquem Neto \",\n" +
                "\"email\":\"rafael.neto@zup.com.br\",\n" +
                "\"descricao\":\"O Contador de Caracteres é uma ferramenta muito simples: ele simplesmente conta caracteres" +
                " e palavras em um texto. Basta você ir digitando o texto no box e o Contador de Caracteres vai te mostrando," +
                " em tempo real, a contagem de palavras e caracteres do seu texto. Se preferir, você também pode copiar e colar" +
                " do Bloco de Notas (ou do seu Editor de Texto predileto) algum texto que você já tenha escrito para " +
                "visualizar a contagem de caracteres e palavras.\"\n" +
                "}";
        mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().is(HttpStatus.BAD_REQUEST.value())
                );
    }


}

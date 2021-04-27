package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AutorRepositoryTest {

    @Autowired
    private AutorRepository autorRepository;


    @Test
    public void criarAutorValidoNoBanco() {
        Autor autor = new Autor("Rafael Benzaquem Neto", "rafael.neto@zup.com.br", "Autor de teste");

        autor = autorRepository.save(autor);

        Assertions.assertNotNull(autor.getId());
    }

    @Test
    public void criarAutorComInstanteNuloNoBanco() {
        Autor autor = new Autor("Andressa Benzaquem", "andreca@email.com", "Autor de teste");

        autor = autorRepository.save(autor);

        Assertions.assertNotNull(autor.getInstante());
    }


}

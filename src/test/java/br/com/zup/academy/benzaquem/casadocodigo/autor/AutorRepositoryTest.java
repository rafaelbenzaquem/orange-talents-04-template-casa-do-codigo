package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
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
    public void criarAutorComInstanteValido() {
        Autor autor = new Autor("Andressa Benzaquem", "andreca@email.com", "Autor de teste");
        autor = autorRepository.save(autor);
        Assertions.assertNotNull(autor.getInstante());
    }

    @Test
    public void buscandoAutorPorEmail() {
        Autor autor = new Autor("Samuel Guilherme", "samuca@email.com", "Autor de teste");
        autorRepository.save(autor);
        autor = autorRepository.findByEmail("samuca@email.com").get();
        Assertions.assertNotNull(autor.getId());
    }

}

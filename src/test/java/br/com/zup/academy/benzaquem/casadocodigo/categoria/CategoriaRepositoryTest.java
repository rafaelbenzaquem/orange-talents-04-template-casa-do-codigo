package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class CategoriaRepositoryTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void buscarCategoriaPorNome(){
        String nome = "Big Data";
        categoriaRepository.save(new Categoria(nome));

        Categoria categoria = categoriaRepository.findByNome(nome).orElse(null);

        Assertions.assertNotNull(categoria);

    }

}

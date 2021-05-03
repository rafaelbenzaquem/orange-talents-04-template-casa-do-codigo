package br.com.zup.academy.benzaquem.casadocodigo.estado;

import br.com.zup.academy.benzaquem.casadocodigo.pais.Pais;
import br.com.zup.academy.benzaquem.casadocodigo.pais.PaisRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class EstadoRepositoryTest {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private PaisRepository paisRepository;

    @Test
    public void buscarEstadoPorNomeEPais() {
        String nomeEstado = "Pará";
        Pais pais = paisRepository.save(new Pais(null, "Brasil"));
        estadoRepository.save(new Estado(null, nomeEstado, pais.getId()));

        Estado estado = estadoRepository.findByNomeAndAndPais_Id(nomeEstado, pais.getId()).orElse(null);
        Assertions.assertNotNull(estado);
    }

}

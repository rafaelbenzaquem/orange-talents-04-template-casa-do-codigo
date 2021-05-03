package br.com.zup.academy.benzaquem.casadocodigo.estado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer> {

    Optional<Estado> findByNomeAndAndPais_Id(String nome,Integer id);
}

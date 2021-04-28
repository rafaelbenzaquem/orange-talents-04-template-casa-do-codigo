package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    Optional<Categoria> findByNome(String nome);
}

package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {

    public Optional<Autor> findByEmail(String email);


}

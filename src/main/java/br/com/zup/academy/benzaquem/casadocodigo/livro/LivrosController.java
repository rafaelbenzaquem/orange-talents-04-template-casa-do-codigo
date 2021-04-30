package br.com.zup.academy.benzaquem.casadocodigo.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping(path = "/livros")
    public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest){
        Livro novoLivro = livroRepository.save(novoLivroRequest.toLivro());
        return ResponseEntity.ok(novoLivro.toResponse());
    }

}

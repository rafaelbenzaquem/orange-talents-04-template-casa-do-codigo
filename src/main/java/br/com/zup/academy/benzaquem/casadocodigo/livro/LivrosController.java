package br.com.zup.academy.benzaquem.casadocodigo.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/livros")
public class LivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
        Livro novoLivro = livroRepository.save(novoLivroRequest.toLivro());
        return ResponseEntity.ok(novoLivro.toNovoLivroResponse());
    }

    @GetMapping
    public ResponseEntity<List<DetalhesLivroResponse>> listar() {
        return ResponseEntity.ok(DetalhesLivroResponse.converter(livroRepository.findAll()));
    }

}

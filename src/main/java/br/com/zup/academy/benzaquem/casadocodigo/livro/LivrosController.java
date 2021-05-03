package br.com.zup.academy.benzaquem.casadocodigo.livro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class LivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<NovoLivroResponse> cadastrar(@RequestBody @Valid NovoLivroRequest novoLivroRequest) {
        Livro novoLivro = livroRepository.save(novoLivroRequest.toLivro());
        return ResponseEntity.ok(new NovoLivroResponse(novoLivro));
    }

    @GetMapping
    public ResponseEntity<List<DetalhesMinimoLivroResponse>> listar() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(DetalhesMinimoLivroResponse.converter(livros));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> recuperarDetalhes(@PathVariable Long id) {
        Optional<Livro> optional = livroRepository.findById(id);
        if (optional.isPresent())
            return ResponseEntity.ok(new DetalhesMaximoLivroResponse(optional.get()));
        return ResponseEntity.badRequest().body("Não existe livro cadastrado com id = " + id);
    }

}

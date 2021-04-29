package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(path = "/categorias")
    public ResponseEntity<NovaCategoriaResponse> cadastrar(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest){
        Categoria categoria = categoriaRepository.save(novaCategoriaRequest.toCategoria());
        return ResponseEntity.ok().body(categoria.toResponse());
    }

}

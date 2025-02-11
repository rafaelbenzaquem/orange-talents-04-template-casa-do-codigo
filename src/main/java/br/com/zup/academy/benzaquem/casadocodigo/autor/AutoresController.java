package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(path = "/autores")
    public ResponseEntity<NovoAutorResponse> criar(@RequestBody @Valid NovoAutorRequest novoAutor){
         Autor  novoAutorSalvo =  autorRepository.save(novoAutor.toAutor());
        return ResponseEntity.ok().body(new NovoAutorResponse(novoAutorSalvo));
    }

}

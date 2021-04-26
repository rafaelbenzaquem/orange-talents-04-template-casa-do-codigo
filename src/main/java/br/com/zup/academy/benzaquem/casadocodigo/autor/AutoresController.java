package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(path = "/autores")
    public ResponseEntity criar(@RequestBody NovoAutorRequest novoAutor){
         Autor  auto =  autorRepository.save(novoAutor.toAutor());
        return ResponseEntity.ok().body("autor criado com sucesso");
    }

}

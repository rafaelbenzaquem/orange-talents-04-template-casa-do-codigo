package br.com.zup.academy.benzaquem.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/paises")
public class PaisesController {

    @Autowired
    private PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity<NovoPaisResponse> cadastrar(@RequestBody @Valid NovoPaisRequest novoPaisRequest){
        Pais pais = paisRepository.save(novoPaisRequest.toModel());
        return ResponseEntity.ok(new NovoPaisResponse(pais));
    }

}

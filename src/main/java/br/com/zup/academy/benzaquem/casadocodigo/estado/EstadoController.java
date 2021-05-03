package br.com.zup.academy.benzaquem.casadocodigo.estado;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<NovoEstadoResponse> cadastrar(@RequestBody @Valid NovoEstadoRequest novoEstadoRequest){
        Estado  estado = estadoRepository.save(novoEstadoRequest.toModel());
        return ResponseEntity.ok(new NovoEstadoResponse(estado));
    }


}

package br.com.zup.academy.benzaquem.casadocodigo.estado;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoUnicoParaPaisValidator implements ConstraintValidator<EstadoUnicoParaPais, NovoEstadoRequest> {

    @Autowired
    private EstadoRepository estadoRepository;

    public boolean isValid(NovoEstadoRequest request, ConstraintValidatorContext context) {
        return !estadoRepository.findByNomeAndAndPais_Id(request.getNome(), request.getPais()).isPresent();
    }
}

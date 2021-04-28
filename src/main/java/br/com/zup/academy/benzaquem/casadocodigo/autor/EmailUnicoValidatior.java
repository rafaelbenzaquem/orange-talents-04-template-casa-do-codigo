package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUnicoValidatior implements ConstraintValidator<EmailUnico, String> {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return autorRepository.findByEmail(email).isPresent() ? false : true;
    }
}

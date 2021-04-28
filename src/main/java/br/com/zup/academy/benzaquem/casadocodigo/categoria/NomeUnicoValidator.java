package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeUnicoValidator implements ConstraintValidator<NomeUnico, String> {

   @Autowired
   private CategoriaRepository categoriaRepository;

    public boolean isValid(String nome, ConstraintValidatorContext context) {
        return !categoriaRepository.findByNome(nome).isPresent();
    }
}

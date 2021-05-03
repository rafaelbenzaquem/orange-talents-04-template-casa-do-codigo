package br.com.zup.academy.benzaquem.casadocodigo.estado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EstadoUnicoParaPaisValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoUnicoParaPais {
    String message() default "{br.com.zup.academy.benzaquem.casadocodigo.estado.EstadoUnicoParaPais.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

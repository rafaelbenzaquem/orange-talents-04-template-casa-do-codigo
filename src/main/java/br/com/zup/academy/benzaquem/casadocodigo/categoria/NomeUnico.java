package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NomeUnicoValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeUnico {

    String message() default "br.com.zup.academy.benzaquem.casadocodigo.categoria.NomeUnico.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

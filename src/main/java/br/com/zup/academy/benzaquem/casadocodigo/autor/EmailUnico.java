package br.com.zup.academy.benzaquem.casadocodigo.autor;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailUnicoValidatior.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnico {
    String message() default "br.com.zup.academy.benzaquem.casadocodigo.EmailUnico.message";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

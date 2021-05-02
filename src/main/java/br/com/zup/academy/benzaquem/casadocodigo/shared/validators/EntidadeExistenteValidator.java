package br.com.zup.academy.benzaquem.casadocodigo.shared.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntidadeExistenteValidator implements ConstraintValidator<EntidadeExistente, Object> {

    private Class<?> domainClass;
    @PersistenceContext
    private EntityManager em;

    public void initialize(EntidadeExistente constraint) {
        this.domainClass = constraint.domainClass();
    }

    public boolean isValid(Object id, ConstraintValidatorContext context) {
        return em.find(domainClass,id)!=null;
    }
}

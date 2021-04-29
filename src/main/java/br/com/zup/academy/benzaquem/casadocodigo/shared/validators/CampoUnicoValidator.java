package br.com.zup.academy.benzaquem.casadocodigo.shared.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, Object> {

    private String fieldName;
    private Class<?> domainClass;

    @PersistenceContext
    private EntityManager entityManager;

    public void initialize(CampoUnico constraint) {
        this.domainClass = constraint.domainClass();
        this.fieldName = constraint.fieldName();
    }


    public boolean isValid(Object valorCampo, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select c from " + domainClass.getSimpleName() + " c where " + fieldName + "=:valorCampo");
        query.setParameter("valorCampo", valorCampo);
        List<?> list = query.getResultList();
        return list.isEmpty();
    }
}

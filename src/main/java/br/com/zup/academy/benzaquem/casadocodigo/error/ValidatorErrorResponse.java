package br.com.zup.academy.benzaquem.casadocodigo.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidatorErrorResponse extends ErrorResponse {

    private List<FieldError> fields = new ArrayList<>();

    public ValidatorErrorResponse(Integer status, String message, LocalDateTime instant) {
        super(status, message, instant);
    }

    public List<FieldError> getFields() {
        return List.copyOf(fields);
    }

    public void addFieldError(String field, String message){
        fields.add(new FieldError(field,message));
    }

}

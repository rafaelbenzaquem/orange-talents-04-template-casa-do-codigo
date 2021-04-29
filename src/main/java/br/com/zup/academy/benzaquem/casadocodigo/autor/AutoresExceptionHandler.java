package br.com.zup.academy.benzaquem.casadocodigo.autor;

import br.com.zup.academy.benzaquem.casadocodigo.shared.message.error.ValidatorErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AutoresExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidatorErrorResponse> fieldValidationExceptionHandler(MethodArgumentNotValidException ex) {
        ValidatorErrorResponse errorResponse = new ValidatorErrorResponse(HttpStatus.BAD_REQUEST.value(), "Erro de validação!", LocalDateTime.now());
        ex.getBindingResult().getFieldErrors().forEach(f -> errorResponse.addFieldError(f.getField(), f.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}

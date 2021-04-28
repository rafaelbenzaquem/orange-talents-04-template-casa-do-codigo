package br.com.zup.academy.benzaquem.casadocodigo.error;

import java.time.LocalDateTime;

public class ErrorResponse {

    private Integer status;
    private String message;
    private LocalDateTime instant;

    public ErrorResponse(Integer status, String message, LocalDateTime instant) {
        this.status = status;
        this.message = message;
        this.instant = instant;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getInstant() {
        return instant;
    }
}

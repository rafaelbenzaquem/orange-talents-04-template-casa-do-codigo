package br.com.zup.academy.benzaquem.casadocodigo.autor;

import java.sql.Timestamp;

public class NovoAutorResponse {

    private Long id;
    private String nome;
    private String email;
    private Timestamp instante;

    public NovoAutorResponse(Autor novoAutor) {
        this.id = novoAutor.getId();
        this.nome = novoAutor.getNome();
        this.email = novoAutor.getEmail();
        this.instante = novoAutor.getInstante();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Timestamp getInstante() {
        return instante;
    }
}

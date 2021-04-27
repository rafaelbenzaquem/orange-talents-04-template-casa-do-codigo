package br.com.zup.academy.benzaquem.casadocodigo.autor;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class NovoAutorRequest {

    @NotBlank
    @NotEmpty
    public String nome;

    @NotEmpty
    @NotBlank
    @Email
    public String email;

    @NotEmpty
    @NotBlank
    @Length(min = 1,max = 400)
    public String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "NovoAutorRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Autor toAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}

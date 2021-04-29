package br.com.zup.academy.benzaquem.casadocodigo.autor;

import br.com.zup.academy.benzaquem.casadocodigo.shared.validators.CampoUnico;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class NovoAutorRequest {

    @NotEmpty(message = "O nome não pode ser vázio, em branco ou nulo!")
    public String nome;

    @NotEmpty(message = "O email não pode ser vázio, em branco ou nulo!")
    @Email(message = "Formato do email não está adaqueado!")
    @CampoUnico(message = "Email já cadastrado no sistema!",fieldName = "email",domainClass = Autor.class)
    public String email;

    @NotEmpty(message = "A descrição não pode ser vázio, em branco ou nulo!")
    @Length(min = 10,max = 400,message ="A descrição deve está entre 10 e 400 caracteres!" )
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

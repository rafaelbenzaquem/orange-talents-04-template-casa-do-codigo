package br.com.zup.academy.benzaquem.casadocodigo.pais;

import br.com.zup.academy.benzaquem.casadocodigo.shared.validators.CampoUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class NovoPaisRequest {

    @NotBlank(message = "O campo 'nome' não pode ser vazio ou nulo.")
    @CampoUnico(message = "Esse país já foi cadastrado!",
            domainClass = Pais.class,fieldName = "nome")
    private String nome;

    public NovoPaisRequest(@JsonProperty(value = "nome") String nome) {
        this.nome = nome;
    }

    public Pais toModel(){
        return new Pais(null,this.nome);
    }
}

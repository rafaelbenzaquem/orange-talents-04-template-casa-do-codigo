package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class NovaCategoriaRequest {

    @NomeUnico
    @NotBlank(message = "Campo nome não pode ser branco ou nulo")
    private String nome;

    public NovaCategoriaRequest(@JsonProperty(value = "nome") String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }

}

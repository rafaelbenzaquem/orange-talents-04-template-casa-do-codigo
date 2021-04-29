package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import br.com.zup.academy.benzaquem.casadocodigo.shared.validators.CampoUnico;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @CampoUnico(message = "Já existe categoria com esse nome!",fieldName = "nome",domainClass = Categoria.class)
    @NotBlank(message = "Campo nome não pode ser branco ou nulo")
    private String nome;

    public NovaCategoriaRequest(@JsonProperty(value = "nome") String nome) {
        this.nome = nome;
    }

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }

}

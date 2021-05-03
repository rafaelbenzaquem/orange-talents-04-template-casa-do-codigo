package br.com.zup.academy.benzaquem.casadocodigo.estado;

import br.com.zup.academy.benzaquem.casadocodigo.pais.Pais;
import br.com.zup.academy.benzaquem.casadocodigo.shared.validators.EntidadeExistente;

import javax.validation.constraints.NotNull;

@EstadoUnicoParaPais
public class NovoEstadoRequest {

    @NotNull
    private String nome;
    @NotNull
    @EntidadeExistente(domainClass = Pais.class)
    private Integer pais;

    public NovoEstadoRequest(String nome, Integer pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado toModel(){
        return new Estado(null,this.nome,pais);
    }

    public String getNome() {
        return nome;
    }

    public Integer getPais() {
        return pais;
    }
}

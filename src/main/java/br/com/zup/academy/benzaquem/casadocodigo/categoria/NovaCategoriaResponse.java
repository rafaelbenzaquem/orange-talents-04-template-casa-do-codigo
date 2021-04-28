package br.com.zup.academy.benzaquem.casadocodigo.categoria;

public class NovaCategoriaResponse {

    private Integer id;
    private String nome;

    public NovaCategoriaResponse(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

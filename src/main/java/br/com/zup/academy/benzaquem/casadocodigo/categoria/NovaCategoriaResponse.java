package br.com.zup.academy.benzaquem.casadocodigo.categoria;

public class NovaCategoriaResponse {

    private Integer id;
    private String nome;

    public NovaCategoriaResponse(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

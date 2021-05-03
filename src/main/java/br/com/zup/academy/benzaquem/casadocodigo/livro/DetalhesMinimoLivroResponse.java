package br.com.zup.academy.benzaquem.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class DetalhesMinimoLivroResponse {

    private Long id;
    private String titulo;

    public DetalhesMinimoLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public DetalhesMinimoLivroResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<DetalhesMinimoLivroResponse> converter(List<Livro> livros) {
        return livros.stream().map(l -> new DetalhesMinimoLivroResponse(l)).collect(Collectors.toList());
    }
}

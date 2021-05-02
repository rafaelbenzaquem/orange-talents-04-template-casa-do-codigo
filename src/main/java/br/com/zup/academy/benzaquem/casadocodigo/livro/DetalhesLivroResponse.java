package br.com.zup.academy.benzaquem.casadocodigo.livro;

import java.util.List;
import java.util.stream.Collectors;

public class DetalhesLivroResponse {

    private Long id;
    private String titulo;

    public DetalhesLivroResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public static List<DetalhesLivroResponse> converter(List<Livro> livros) {
        return livros.stream().map(Livro::toLivroDeListaResponse).collect(Collectors.toList());
    }
}

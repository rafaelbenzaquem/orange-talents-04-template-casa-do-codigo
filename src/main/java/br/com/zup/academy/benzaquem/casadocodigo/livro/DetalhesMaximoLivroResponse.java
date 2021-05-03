package br.com.zup.academy.benzaquem.casadocodigo.livro;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesMaximoLivroResponse {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer pag;
    private String isbn;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate lancamento;
    private String categoria;
    private String autor;
    private String emailAutor;
    private String descricaoAutor;

    public DetalhesMaximoLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.pag = livro.getPag();
        this.isbn = livro.getIsbn();
        this.lancamento = livro.getLancamento();
        this.categoria = livro.getCategoria() == null ? null : livro.getCategoria().getNome();
        this.autor = livro.getAutor() == null ? null : livro.getAutor().getNome();
        this.emailAutor = livro.getAutor() == null ? null : livro.getAutor().getEmail();
        this.descricaoAutor = livro.getAutor() == null ? null : livro.getAutor().getDescricao();

    }


    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPag() {
        return pag;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getLancamento() {
        return lancamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public String getDescricaoAutor() {
        return descricaoAutor;
    }

    public static List<DetalhesMaximoLivroResponse> converter(List<Livro> livros) {
        return livros.stream().map(l -> new DetalhesMaximoLivroResponse(l)).collect(Collectors.toList());
    }
}

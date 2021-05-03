package br.com.zup.academy.benzaquem.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroResponse {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer pag;
    private String isbn;
    private LocalDate lancamento;
    private Integer idCategoria;
    private Long idAutor;

    @Deprecated
    public NovoLivroResponse() {
    }

    public NovoLivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.pag = livro.getPag();
        this.isbn = livro.getIsbn();
        this.lancamento = livro.getLancamento();
        this.idAutor = livro.getAutor() == null ? null : livro.getAutor().getId();
        this.idCategoria = livro.getCategoria() == null ? null : livro.getCategoria().getId();
    }

    private NovoLivroResponse(Builder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.resumo = builder.resumo;
        this.sumario = builder.sumario;
        this.preco = builder.preco;
        this.pag = builder.pag;
        this.isbn = builder.isbn;
        this.lancamento = builder.lancamento;
        this.idAutor = builder.idAutor;
        this.idCategoria = builder.idCategoria;

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

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public static class Builder {
        private Long id;
        private String titulo;
        private String resumo;
        private String sumario;
        private BigDecimal preco;
        private Integer pag;
        private String isbn;
        private LocalDate lancamento;
        private Integer idCategoria;
        private Long idAutor;

        public Builder(Long id, String titulo, String resumo, Integer idCategoria, Long idAutor) {
            this.id = id;
            this.titulo = titulo;
            this.resumo = resumo;
            this.idCategoria = idCategoria;
            this.idAutor = idAutor;
        }


        public Builder sumario(String sumario) {
            this.sumario = sumario;
            return this;
        }

        public Builder preco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Builder pag(Integer pag) {
            this.pag = pag;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder lancamento(LocalDate lancamento) {
            this.lancamento = lancamento;
            return this;
        }

        public NovoLivroResponse build() {
            return new NovoLivroResponse(this);
        }


    }
}
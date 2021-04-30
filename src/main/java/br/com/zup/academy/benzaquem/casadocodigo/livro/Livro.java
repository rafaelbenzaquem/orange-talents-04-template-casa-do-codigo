package br.com.zup.academy.benzaquem.casadocodigo.livro;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    @Column(length = 500)
    private String resumo;
    @Lob
    private String sumario;
    private BigDecimal preco;
    private Integer pag;
    private String isbn;
    private LocalDate lancamento;
    private Integer idCategoria;
    private Long idAutor;

    private Livro(Builder builder) {
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

    @Deprecated
    public Livro() {
    }

    public NovoLivroResponse toResponse() {
        return new NovoLivroResponse.Builder(this.id, this.titulo, this.resumo, this.idCategoria, this.idAutor)
                .sumario(this.sumario)
                .preco(this.preco)
                .pag(this.pag)
                .isbn(this.isbn)
                .lancamento(this.lancamento)
                .build();
    }


    public static class Builder {
        private String titulo;
        private String resumo;
        private String sumario;
        private BigDecimal preco;
        private Integer pag;
        private String isbn;
        private LocalDate lancamento;
        private Integer idCategoria;
        private Long idAutor;

        public Builder(String titulo, String resumo, Integer idCategoria, Long idAutor) {
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

        public Livro build() {
            return new Livro(this);
        }
    }
}

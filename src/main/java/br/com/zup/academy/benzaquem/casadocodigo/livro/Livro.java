package br.com.zup.academy.benzaquem.casadocodigo.livro;

import br.com.zup.academy.benzaquem.casadocodigo.autor.Autor;
import br.com.zup.academy.benzaquem.casadocodigo.categoria.Categoria;

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
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

    private Livro(Builder builder) {
        this.titulo = builder.titulo;
        this.resumo = builder.resumo;
        this.sumario = builder.sumario;
        this.preco = builder.preco;
        this.pag = builder.pag;
        this.isbn = builder.isbn;
        this.lancamento = builder.lancamento;
        this.autor = builder.autor;
        this.categoria = builder.categoria;
    }

    @Deprecated
    public Livro() {
    }

    public NovoLivroResponse toNovoLivroResponse() {
        return new NovoLivroResponse.Builder(this.id, this.titulo, this.resumo, this.categoria.getId(), this.autor.getId())
                .sumario(this.sumario)
                .preco(this.preco)
                .pag(this.pag)
                .isbn(this.isbn)
                .lancamento(this.lancamento)
                .build();
    }

    public DetalhesLivroResponse toLivroDeListaResponse(){
        return new DetalhesLivroResponse(this.id,this.titulo);
    }


    public static class Builder {

        private String titulo;
        private String resumo;
        private String sumario;
        private BigDecimal preco;
        private Integer pag;
        private String isbn;
        private LocalDate lancamento;
        private Categoria categoria;
        private Autor autor;

        public Builder(String titulo, String resumo, Categoria categoria, Autor autor) {
            this.titulo = titulo;
            this.resumo = resumo;
            this.categoria = categoria;
            this.autor = autor;
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

package br.com.zup.academy.benzaquem.casadocodigo.livro;

import br.com.zup.academy.benzaquem.casadocodigo.autor.Autor;
import br.com.zup.academy.benzaquem.casadocodigo.categoria.Categoria;
import br.com.zup.academy.benzaquem.casadocodigo.shared.validators.CampoUnico;
import br.com.zup.academy.benzaquem.casadocodigo.shared.validators.EntidadeExistente;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroRequest {

    @CampoUnico(message = "Já existe livro cadastrado com esse título!",
            fieldName = "titulo",
            domainClass = Livro.class)
    @NotBlank(message = "Campo 'titulo' não pode ser branco ou nulo!")
    private String titulo;
    @Length(max = 500,message ="O resumo tem limite de 500 caracteres!" )
    private String resumo;
    private String sumario;
    @Min(20)
    private BigDecimal preco;
    @Min(100)
    private Integer pag;
    @CampoUnico(message = "Já existe livro cadastrado com esse isbn!",
            fieldName = "isbn",
            domainClass = Livro.class)
    private String isbn;
    @Future(message = "O lançamento precisa está no futuro.")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "O lançamento não pode ser nulo.")
    private LocalDate lancamento;
    @NotNull(message = "O campo categoria não pode ser nulo")
    @EntidadeExistente(message = "Não existe categoria com esse id",domainClass = Categoria.class)
    private Integer categoria;
    @NotNull(message = "O campo autor não pode ser nulo")
    @EntidadeExistente(message = "Não existe autor com esse id",domainClass = Autor.class)
    private Long autor;


    public Livro toLivro() {
        return new Livro.Builder(titulo, resumo, new Categoria(this.categoria), new Autor(autor))
                .sumario(sumario)
                .preco(preco)
                .pag(pag)
                .isbn(isbn)
                .lancamento(lancamento)
                .build();
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

    public Integer getCategoria() {
        return categoria;
    }

    public Long getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "NovoLivroRequest{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", pag=" + pag +
                ", isbn='" + isbn + '\'' +
                ", lancamento=" + lancamento +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}

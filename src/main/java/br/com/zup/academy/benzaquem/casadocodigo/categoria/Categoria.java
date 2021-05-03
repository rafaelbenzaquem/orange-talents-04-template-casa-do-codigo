package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import br.com.zup.academy.benzaquem.casadocodigo.livro.Livro;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

    @Deprecated
    public Categoria() {
    }

    public Categoria(Integer id) {
        this.id = id;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}

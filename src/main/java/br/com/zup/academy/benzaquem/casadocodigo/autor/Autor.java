package br.com.zup.academy.benzaquem.casadocodigo.autor;

import br.com.zup.academy.benzaquem.casadocodigo.livro.Livro;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Column(length = 400)
    private String descricao;
    @CreationTimestamp
    private Timestamp instante;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    @Deprecated
    public Autor() {
    }

    public Autor(Long id) {
        Id = id;
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Timestamp getInstante() {
        return instante;
    }

    public List<Livro> getLivros() {
        return livros;
    }
}

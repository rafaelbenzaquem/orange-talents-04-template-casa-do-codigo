package br.com.zup.academy.benzaquem.casadocodigo.pais;

import br.com.zup.academy.benzaquem.casadocodigo.estado.Estado;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;

    @Deprecated
    public Pais() {
    }

    public Pais(Integer id, String name) {
        this.id = id;
        this.nome = name;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstados() {
        return Collections.unmodifiableList(this.estados);
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

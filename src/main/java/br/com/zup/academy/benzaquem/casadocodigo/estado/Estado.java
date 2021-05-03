package br.com.zup.academy.benzaquem.casadocodigo.estado;

import br.com.zup.academy.benzaquem.casadocodigo.pais.Pais;

import javax.persistence.*;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado(){
    }

    public Estado(Integer id, String nome, Integer idPais) {
        this.id=id;
        this.nome=nome;
        this.pais = new Pais(idPais,null);
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }
}

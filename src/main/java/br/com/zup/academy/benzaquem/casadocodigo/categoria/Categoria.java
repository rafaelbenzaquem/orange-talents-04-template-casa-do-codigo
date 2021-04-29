package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nome;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.nome=nome;
    }

    public NovaCategoriaResponse toResponse() {
        return  new NovaCategoriaResponse(this.id,this.nome);
    }
}

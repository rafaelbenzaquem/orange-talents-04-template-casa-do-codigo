package br.com.zup.academy.benzaquem.casadocodigo.categoria;

import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

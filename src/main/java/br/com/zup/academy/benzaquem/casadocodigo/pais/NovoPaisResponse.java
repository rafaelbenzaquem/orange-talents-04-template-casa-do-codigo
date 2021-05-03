package br.com.zup.academy.benzaquem.casadocodigo.pais;

public class NovoPaisResponse {

    private Integer id;
    private String nome;

    public NovoPaisResponse(Pais pais) {
    this.id = pais.getId();
    this.nome=pais.getNome();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}

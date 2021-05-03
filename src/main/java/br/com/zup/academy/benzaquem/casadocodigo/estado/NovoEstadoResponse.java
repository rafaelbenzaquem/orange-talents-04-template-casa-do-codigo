package br.com.zup.academy.benzaquem.casadocodigo.estado;

public class NovoEstadoResponse {

    private Integer id;
    private String nome;
    private Integer pais;

    public NovoEstadoResponse(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = estado.getPais() == null ? null : estado.getPais().getId();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPais() {
        return pais;
    }
}

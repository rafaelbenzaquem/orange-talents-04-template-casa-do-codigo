package br.com.zup.academy.benzaquem.casadocodigo.autor;

public class NovoAutorRequest {

    public String nome;
    public String email;
    public String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    @Override
    public String toString() {
        return "NovoAutorRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Autor toAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}

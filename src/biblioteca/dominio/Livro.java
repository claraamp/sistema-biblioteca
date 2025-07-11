package biblioteca.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Livro {
    private String idLivro;
    private String titulo;
    private String editora;
    private List<String> autores;
    private String edicao;
    private int anoDePublicacao;
    private List<Exemplar> exemplares = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Livro(String idLivro, String titulo, String editora, List<String> autores, String edicao, int anoDePublicacao) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
    }

    public void adicionarExemplar(Exemplar e) { this.exemplares.add(e); }

    public void adicionarReserva(Reserva r) { this.reservas.add(r); }

    public void removerReservaParaUsuario(Usuario u) {
        reservas.removeIf(reserva -> reserva.getUsuario().equals(u));
    }

    public boolean usuarioTemReserva(Usuario u) {
        return reservas.stream().anyMatch(r -> r.getUsuario().equals(u));
    }

    public long getQuantidadeExemplaresDisponiveis() {
        return exemplares.stream().filter(e -> !e.isEmprestado()).count();
    }
    public Optional<Exemplar> getExemplarDisponivel() {
        return exemplares.stream().filter(e -> !e.isEmprestado()).findFirst();
    }
    public String getIdLivro() {
        return idLivro;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getEditora() {
        return editora;
    }
    public List<String> getAutores() {
        return autores;
    }
    public String getEdicao() {
        return edicao;
    }
    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }
    public List<Exemplar> getExemplares() {
        return exemplares;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(idLivro, livro.idLivro);
    }
    @Override
    public int hashCode() { return Objects.hash(idLivro); }
}

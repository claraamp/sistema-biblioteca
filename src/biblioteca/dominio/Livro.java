package biblioteca.dominio;

import biblioteca.observer.Observador;
import biblioteca.observer.Sujeito;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Livro implements Sujeito {
    private String codigo;
    private String titulo;
    private String editora;
    private List<String> autores;
    private String edicao;
    private int anoDePublicacao;
    private List<Exemplar> exemplares = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Observador> observadores;

    public Livro(String codigo, String titulo, String editora, List<String> autores, String edicao, int anoDePublicacao) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
        this.observadores = new ArrayList<>();
    }

    public void adicionarExemplar(Exemplar e) { this.exemplares.add(e); }

    public void adicionarReserva(Reserva r) {
        this.reservas.add(r);

        if (this.reservas.size() > 2) {
            notificarObservadores();
        }
    }

    public void removerReservaParaUsuario(Usuario u) {
        reservas.removeIf(reserva -> reserva.getUsuario().equals(u));
    }

    public boolean usuarioTemReserva(Usuario u) {
        return reservas.stream().anyMatch(r -> r.getUsuario().equals(u));
    }

    @Override
    public void registrarObservador(Observador observador) {
        this.observadores.add(observador);
    }
    @Override
    public void removerObservador(Observador observador) {
        this.observadores.remove(observador);

    }
    @Override
    public void notificarObservadores() {
        for (Observador observador : this.observadores) {
            observador.atualizar(this);
        }
    }

    public long getQuantidadeExemplaresDisponiveis() {
        return exemplares.stream().filter(e -> !e.isEmprestado()).count();
    }
    public Optional<Exemplar> getExemplarDisponivel() {
        return exemplares.stream().filter(e -> !e.isEmprestado()).findFirst();
    }
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
//    public String getEditora() { return editora; }
//    public List<String> getAutores() { return autores; }
//    public String getEdicao() { return edicao; }
//    public int getAnoDePublicacao() { return anoDePublicacao; }
    public List<Exemplar> getExemplares() { return exemplares;}
    public List<Reserva> getReservas() { return reservas; }
    public List<Observador> getObservadores() { return observadores; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(codigo, livro.codigo);
    }
    @Override
    public int hashCode() { return Objects.hash(codigo); }
}


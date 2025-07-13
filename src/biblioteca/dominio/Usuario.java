package biblioteca.dominio;

import biblioteca.observer.Observador;
import biblioteca.observer.Sujeito;
import biblioteca.regras.RegraEmprestimo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Usuario implements Observador {
    private String codigo;
    private String nome;
    private List<Emprestimo> emprestimosEmAberto;
    private List<Reserva> reservas;
    protected RegraEmprestimo regraEmprestimo;
    private List<Emprestimo> historicoEmprestimos;
    private int contadorNotificacoes;


    public Usuario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimosEmAberto = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.historicoEmprestimos = new ArrayList<>();
        this.contadorNotificacoes = 0;
    }

    public boolean isDevedor() {
        final LocalDate hoje = LocalDate.now();
        for (Emprestimo emprestimo : emprestimosEmAberto) {
            if (hoje.isAfter(emprestimo.getDataDevolucao())) {
                return true;
            }
        }
        return false;
    }

    public boolean temEmprestimoDoLivro(Livro livro) {
        return emprestimosEmAberto.stream()
                .anyMatch(e -> e.getExemplar().getLivro().equals(livro));
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimosEmAberto.add(emprestimo);
    }

    public void adicionarReserva(Reserva reserva) { this.reservas.add(reserva); }

    public void finalizarEmprestimo(Emprestimo emprestimo) {
        this.emprestimosEmAberto.remove(emprestimo);
        this.historicoEmprestimos.add(emprestimo);
    }

    @Override
    public void atualizar(Sujeito sujeito) {
        this.contadorNotificacoes++;
        System.out.println("[System Log] Notificando observador " + this.getNome() + ". Total de notificações: " + this.contadorNotificacoes);
    }

    public abstract int getTempoEmprestimo();
    public abstract int getLimiteEmprestimosAberto();
    public List<Emprestimo> getEmprestimosEmAberto() {
        return emprestimosEmAberto;
    }
    public String getCodigo() { return codigo; }
    public String getNome() {
        return nome;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }
    public RegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }
    public List<Emprestimo> getHistoricoEmprestimos() { return historicoEmprestimos; }
    public int getContadorNotificacoes() { return contadorNotificacoes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(codigo, usuario.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

}

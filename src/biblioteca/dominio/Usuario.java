package biblioteca.dominio;

import biblioteca.regras.RegraEmprestimo;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Usuario {
    private String codigo;
    private String nome;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;
    protected RegraEmprestimo regraEmprestimo;


    public Usuario(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public boolean isDevedor() {
        final LocalDate hoje = LocalDate.now();
        for (Emprestimo emprestimo : emprestimos) {
            if (hoje.isAfter(emprestimo.getDataDevolucao())) {
                return true;
            }
        }
        return false;
    }

    public boolean temEmprestimoDoLivro(Livro livro) {
        return emprestimos.stream()
                .anyMatch(e -> e.getExemplar().getLivro().equals(livro));
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) { this.emprestimos.remove(emprestimo); }

    public void adicionarReserva(Reserva reserva) { this.reservas.add(reserva); }

    public abstract int getTempoEmprestimo();
    public abstract int getLimiteEmprestimosAberto();
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
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

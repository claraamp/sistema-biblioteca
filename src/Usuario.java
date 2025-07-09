import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Usuario {
    private String idUsuario;
    private String nome;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;
    protected IRegraEmprestimo regraEmprestimo;


    public Usuario(String codigo, String nome) {
        this.idUsuario = idUsuario;
        this.nome = nome;
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

    public abstract int getTempoEmprestimo();

    public abstract int getLimiteEmprestimosAberto();

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public boolean temEmprestimoDoLivro(Livro livro) {
        return emprestimos.stream()
                .anyMatch(e -> e.getExemplar().getLivro().equals(livro));
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public String getIdUsuario() { return idUsuario; }
    public String getNome() {
        return nome;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }
    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(idUsuario, usuario.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }

}

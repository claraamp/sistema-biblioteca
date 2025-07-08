import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private String idUsuario;
    private String nome;
    private int tempoEmprestimo;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;
    protected IRegraEmprestimo regraEmprestimo;


    public Usuario(String idUsuario, String nome, List<Emprestimo> emprestimos, List<Reserva> reservas) {
        this.idUsuario = idUsuario;
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

    public String getNome() {
        return nome;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

}

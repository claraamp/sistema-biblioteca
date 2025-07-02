import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected String idUsuario;
    protected String nome;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;


    public Usuario(String idUsuario, String nome, List<Emprestimo> emprestimos, List<Reserva> reservas) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
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

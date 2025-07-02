import java.util.List;

public class AlunoGraducao extends Usuario{

    public AlunoGraducao(String idUsuario, String nome, List<Emprestimo> emprestimosAtuais, List<Emprestimo> historicoEmprestimos, List<Reserva> reservas) {
        super(idUsuario, nome, emprestimosAtuais, reservas);
    }
}

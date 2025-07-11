package biblioteca.comando;

import biblioteca.repositorio.Repositorio;
import biblioteca.dominio.Livro;
import biblioteca.dominio.Exemplar;
import biblioteca.dominio.Reserva;
import biblioteca.dominio.Emprestimo;
import biblioteca.dominio.Usuario;

import java.time.format.DateTimeFormatter;
import java.util.List;


public class ConsultarLivroComando implements Comando {

    public ConsultarLivroComando() {}

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        String idLivro = carregadorParametros.getParametroUm();

        Repositorio repositorio = Repositorio.obterInstancia();
        Livro livro = repositorio.buscarLivroPorId(idLivro);

        if (livro == null) {
            System.out.println("Erro: Livro com código '" + idLivro + "' não encontrado.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Título: " + livro.getTitulo());

        List<Reserva> reservas = livro.getReservas();
        System.out.println("Reservas: " + reservas.size());
        if (!reservas.isEmpty()) {
            System.out.println("Usuários com reserva:");
            for (Reserva reserva : reservas) {
                System.out.println("  - " + reserva.getUsuario().getNome());
            }
        }

        System.out.println("---");

        System.out.println("Exemplares:");
        List<Exemplar> exemplares = livro.getExemplares();
        if (exemplares.isEmpty()) {
            System.out.println("  Nenhum exemplar cadastrado para este livro.");
        } else {
            for (Exemplar exemplar : exemplares) {
                System.out.print("  - Exemplar " + exemplar.getCodigoExemplar() + ": ");
                if (exemplar.isEmprestado()) {
                    Emprestimo emprestimoCorrente = exemplar.getEmprestimoCorrente();
                    Usuario usuarioDoEmprestimo = emprestimoCorrente.getUsuario();

                    System.out.println("Emprestado para " + usuarioDoEmprestimo.getNome() +
                            " (cód. " + usuarioDoEmprestimo.getIdUsuario() + ")" +
                            " | Data do Empréstimo: " + emprestimoCorrente.getDataEmprestimo().format(formatter) +
                            " | Devolução Prevista: " + emprestimoCorrente.getDataDevolucao().format(formatter));
                } else {
                    System.out.println("Disponível");
                }
            }

        }
    }
}

package biblioteca.comando;

import biblioteca.dominio.Emprestimo;
import biblioteca.dominio.Reserva;
import biblioteca.dominio.Usuario;
import biblioteca.repositorio.Repositorio;

import java.time.format.DateTimeFormatter;

public class ConsultarUsuarioComando implements Comando{

    public ConsultarUsuarioComando() {}

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        String codigoUsuario = carregadorParametros.getParametroUm();

        Repositorio repositorio = Repositorio.obterInstancia();
        Usuario usuario = repositorio.buscarUsuarioPorCodigo(codigoUsuario);

        if (usuario == null) {
            System.out.println("Erro: Usuário com código '" + codigoUsuario + "' não encontrado.");
            return;
        }

        System.out.println("Consultando o Usuário: " + usuario.getNome() + " (cód. " + usuario.getCodigo() + ")");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("--- Empréstimos em Curso ---");
        if (usuario.getEmprestimos().isEmpty()) {
            System.out.println("Nenhum empréstimo em curso.");
        } else {
            for (Emprestimo emprestimo : usuario.getEmprestimos()) {
                System.out.println("  - Livro: " + emprestimo.getExemplar().getLivro().getTitulo());
                System.out.println("     Data do Empréstimo: " + emprestimo.getDataEmprestimo().format(formatter));
                System.out.println("     Status: Em curso");
                System.out.println("     Devolução Prevista: " + emprestimo.getDataDevolucao().format(formatter));
            }
        }

        System.out.println("\n--- Histórico de Empréstimos ---");
        if (usuario.getHistoricoEmprestimos().isEmpty()) {
            System.out.println("Nenhum empréstimo no histórico.");
        } else {
            for (Emprestimo emprestimo : usuario.getHistoricoEmprestimos()) {
                System.out.println("  - Livro: " + emprestimo.getExemplar().getLivro().getTitulo());
                System.out.println("     Data do Empréstimo: " + emprestimo.getDataEmprestimo().format(formatter));
                System.out.println("     Status: Finalizado");
                System.out.println("     Devolução Prevista era: " + emprestimo.getDataDevolucao().format(formatter));
            }
        }

        System.out.println("\n--- Reservas Ativas ---");
        if (usuario.getReservas().isEmpty()) {
            System.out.println("Nenhuma reserva ativa.");
        } else {
            for (Reserva reserva : usuario.getReservas()) {
                System.out.println("  - Livro: " + reserva.getLivro().getTitulo());
                System.out.println("     Data da Reserva: " + reserva.getDataReserva().format(formatter));
            }
        }



    }
}

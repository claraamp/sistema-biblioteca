package biblioteca.regras;

import biblioteca.dominio.AlunoGraduacao;
import biblioteca.dominio.AlunoPosGraduacao;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.excecao.EmprestimoException;

public class RegraEmprestimoAluno implements RegraEmprestimo {
    @Override
    public void validaEmprestimo(Usuario usuario, Livro livro) throws EmprestimoException {
        long exemplaresDisponiveis = livro.getQuantidadeExemplaresDisponiveis();

        if (exemplaresDisponiveis == 0) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois não há exemplares disponíveis para o livro '" + livro.getTitulo() + "'.");
        }

        if (usuario.isDevedor()) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois o usuário possui livros em atraso.");
        }

        if (usuario.getEmprestimos().size() >= usuario.getLimiteEmprestimosAberto()) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois o usuário atingiu o limite de " + usuario.getLimiteEmprestimosAberto() + " livros.");
        }

        long numeroReservasDeAlunos = livro.getReservas().stream()
                .filter(reserva -> reserva.getUsuario() instanceof AlunoGraduacao || reserva.getUsuario() instanceof AlunoPosGraduacao)
                .count();

        boolean usuarioTemReserva = livro.usuarioTemReserva(usuario);

        if (numeroReservasDeAlunos >= exemplaresDisponiveis && !usuarioTemReserva) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois todos os exemplares disponíveis estão reservados.");
        }


        if (usuario.temEmprestimoDoLivro(livro)) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois o usuário já possui um exemplar deste livro.");
        }

    }
}

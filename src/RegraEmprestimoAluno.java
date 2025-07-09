public class RegraEmprestimoAluno implements IRegraEmprestimo{
    @Override
    public void validaEmprestimo(Usuario usuario, Livro livro) throws EmprestimoException {
        if (livro.getQuantidadeExemplaresDisponiveis() == 0) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois não há exemplares disponíveis para o livro '" + livro.getTitulo() + "'.");
        }

        if (usuario.isDevedor()) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois o usuário possui livros em atraso.");
        }

        if (usuario.getEmprestimos().size() >= usuario.getLimiteEmprestimosAberto()) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois o usuário atingiu o limite de " + usuario.getLimiteEmprestimosAberto() + " livros.");
        }

       /* long numeroReservas = livro.getReservas().size();
        boolean usuarioTemReserva = livro.usuarioTemReserva(usuario);

        if (numeroReservas >= exemplaresDisponiveis && !usuarioTemReserva) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois todos os exemplares disponíveis estão reservados.");
        }*/

        if (usuario.temEmprestimoDoLivro(livro)) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois o usuário já possui um exemplar deste livro.");
        }
    }
}

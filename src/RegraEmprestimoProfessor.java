public class RegraEmprestimoProfessor implements IRegraEmprestimo{

    @Override
    public void validaEmprestimo(Usuario usuario, Livro livro) throws EmprestimoException {
        if (livro.getQuantidadeExemplaresDisponiveis() == 0) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois não há exemplares disponíveis para o livro '" + livro.getTitulo() + "'.");
        }

        if (usuario.isDevedor()) {
            throw new EmprestimoException("Não foi possível realizar o empréstimo, pois o usuário possui livros em atraso.");
        }

    }
}

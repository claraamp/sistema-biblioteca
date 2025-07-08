public interface IRegraEmprestimo {
    void validaEmprestimo(Usuario usuario, Livro livro) throws EmprestimoException;
}

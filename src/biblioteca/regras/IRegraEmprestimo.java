package biblioteca.regras;

import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.excecao.EmprestimoException;

public interface IRegraEmprestimo {
    void validaEmprestimo(Usuario usuario, Livro livro) throws EmprestimoException;
}

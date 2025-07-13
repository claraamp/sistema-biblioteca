package biblioteca.regras;

import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.exceptions.EmprestimoException;

public interface RegraEmprestimo {
    void validaEmprestimo(Usuario usuario, Livro livro) throws EmprestimoException;
}

package biblioteca.servico;

import biblioteca.dominio.Emprestimo;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.dominio.Exemplar;
import biblioteca.excecao.DevolucaoException;

import java.util.Optional;

public class DevolucaoService {

    public static void realizarDevolucao(Usuario usuario, Livro livro) throws DevolucaoException {
        Optional<Emprestimo> emprestimoOpt = usuario.getEmprestimos().stream()
                .filter(e -> e.getExemplar().getLivro().equals(livro))
                .findFirst();

        if (emprestimoOpt.isEmpty()) {
            throw new DevolucaoException("Empréstimo para o livro '" + livro.getTitulo() + "' não encontrado para o usuário '" + usuario.getNome() + "'.");
        }

        Emprestimo emprestimoParaRemover = emprestimoOpt.get();
        Exemplar exemplarParaDevolver = emprestimoParaRemover.getExemplar();

        usuario.removerEmprestimo(emprestimoParaRemover);
        exemplarParaDevolver.setEmprestimoCorrente(null);
    }
}

package biblioteca.servico;

import biblioteca.dominio.Emprestimo;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.dominio.Exemplar;
import biblioteca.exceptions.DevolucaoException;

import java.util.Optional;

public class DevolucaoService {

    public static void realizarDevolucao(Usuario usuario, Livro livro) throws DevolucaoException {
        Optional<Emprestimo> emprestimoOpt = usuario.getEmprestimosEmAberto().stream()
                .filter(e -> e.getExemplar().getLivro().equals(livro))
                .findFirst();

        if (emprestimoOpt.isEmpty()) {
            throw new DevolucaoException("Empréstimo para o livro '" + livro.getTitulo() + "' não encontrado para o usuário '" + usuario.getNome() + "'.");
        }

        Emprestimo emprestimoParaFinalizar = emprestimoOpt.get();
        Exemplar exemplarParaDevolver = emprestimoParaFinalizar.getExemplar();

        usuario.finalizarEmprestimo(emprestimoParaFinalizar);
        exemplarParaDevolver.setEmprestimoCorrente(null);
    }
}

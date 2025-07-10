package biblioteca.comando;

import biblioteca.servico.DevolucaoService;
import biblioteca.repositorio.Repositorio;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.excecao.DevolucaoException;


public class DevolucaoComando implements IComando {

    private final DevolucaoService devolucaoService;
    private final String idUsuario;
    private final String idLivro;

    public DevolucaoComando(DevolucaoService devolucaoService, String idUsuario, String idLivro) {
        this.devolucaoService = devolucaoService;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    @Override
    public void execute() {
        Repositorio repositorio = Repositorio.obterInstancia();
        Usuario usuario = repositorio.buscarUsuarioPorId(idUsuario);
        Livro livro = repositorio.buscarLivroPorId(idLivro);

        if (usuario == null) {
            System.out.println("Erro: Usuário com código '" + idUsuario + "' não encontrado.");
            return;
        }

        if (livro == null) {
            System.out.println("Erro: Livro com código '" + idLivro + "' não encontrado.");
            return;
        }

        try {
            devolucaoService.realizarDevolucao(usuario, livro);
            System.out.println("Devolução do livro '" + livro.getTitulo() + "' por '" + usuario.getNome() + "' realizada.");

        } catch (DevolucaoException e) {
            System.out.println(e.getMessage());
        }
    }
}

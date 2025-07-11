package biblioteca.comando;

import biblioteca.servico.DevolucaoService;
import biblioteca.repositorio.Repositorio;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.excecao.DevolucaoException;


public class DevolverComando implements Comando {

    public DevolverComando() {}

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        String codigoUsuario = carregadorParametros.getParametroUm();
        String codigoLivro = carregadorParametros.getParametroDois();

        Repositorio repositorio = Repositorio.obterInstancia();
        Usuario usuario = repositorio.buscarUsuarioPorCodigo(codigoUsuario);
        Livro livro = repositorio.buscarLivroPorCodigo(codigoLivro);

        if (usuario == null) {
            System.out.println("Erro: Usuário com código '" + codigoUsuario + "' não encontrado.");
            return;
        }

        if (livro == null) {
            System.out.println("Erro: Livro com código '" + codigoLivro + "' não encontrado.");
            return;
        }

        try {
            DevolucaoService.realizarDevolucao(usuario, livro);
            System.out.println("Devolução do livro '" + livro.getTitulo() + "' por '" + usuario.getNome() + "' realizada com sucesso.");

        } catch (DevolucaoException e) {
            System.out.println(e.getMessage());
        }
    }
}

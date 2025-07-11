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
        String idUsuario = carregadorParametros.getParametroUm();
        String idLivro = carregadorParametros.getParametroDois();

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
            DevolucaoService.realizarDevolucao(usuario, livro);
            System.out.println("Devolução do livro '" + livro.getTitulo() + "' por '" + usuario.getNome() + "' realizada.");

        } catch (DevolucaoException e) {
            System.out.println(e.getMessage());
        }
    }
}

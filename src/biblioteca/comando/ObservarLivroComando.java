package biblioteca.comando;

import biblioteca.dominio.Livro;
import biblioteca.dominio.Usuario;
import biblioteca.exceptions.ObservadorException;
import biblioteca.repositorio.Repositorio;
import biblioteca.servico.ObservadorService;

public class ObservarLivroComando implements Comando {

    public ObservarLivroComando() {}

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterInstancia();
        ObservadorService observadorService = new ObservadorService();

        Usuario usuario = repositorio.buscarUsuarioPorCodigo(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivroPorCodigo(carregadorParametros.getParametroDois());

        if (usuario == null || livro == null) {
            System.out.println("Erro: Usuário ou livro não encontrado.");
            return;
        }

        try {
            observadorService.registrarObservador(usuario, livro);
            System.out.println("Usuário '" + usuario.getNome() + "' agora é um observador do livro '" + livro.getTitulo() + "'.");
        } catch (ObservadorException e) {
            System.out.println(e.getMessage());
        }

    }
}

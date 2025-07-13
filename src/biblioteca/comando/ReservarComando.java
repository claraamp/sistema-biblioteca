package biblioteca.comando;

import biblioteca.repositorio.Repositorio;
import biblioteca.servico.ReservaService;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.exceptions.ReservaException;

public class ReservarComando implements Comando {

    public ReservarComando() {}

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        String codigoUsuario = carregadorParametros.getParametroUm();
        String codigoLivro = carregadorParametros.getParametroDois();

        Repositorio repositorio = Repositorio.obterInstancia();
        ReservaService reservaService = new ReservaService();

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
            reservaService.realizarReserva(usuario, livro);
            System.out.println("Reserva para o livro '" + livro.getTitulo() + "' registrada para o usuário '" + usuario.getNome() + "' realizada com sucesso.");
        } catch (ReservaException e) {
            System.out.println(e.getMessage());
        }
    }
}
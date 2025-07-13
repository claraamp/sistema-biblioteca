package biblioteca.comando;

import biblioteca.dominio.Usuario;
import biblioteca.repositorio.Repositorio;

public class ConsultarNotificacoesComando implements Comando{
    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        String idUsuario = carregadorParametros.getParametroUm();

        Repositorio repositorio = Repositorio.obterInstancia();
        Usuario usuario = repositorio.buscarUsuarioPorCodigo(idUsuario);

        if (usuario == null) {
            System.out.println("Erro: Usuário com código '" + idUsuario + "' não encontrado.");
            return;
        }

        int totalNotificacoes = usuario.getContadorNotificacoes();

        System.out.println("O usuário '" + usuario.getNome() + "' (cód. " + usuario.getCodigo() + ") possui " + totalNotificacoes + " notif.");
    }
}

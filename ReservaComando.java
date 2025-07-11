package comando;

import dominio.Usuario;
import dominio.Livro;
import repositorio.BibliotecaRepositorio;
import servico.ServicoReserva;

public class ReservaComando implements Comando {

    private String[] argumentos;

    public ReservaComando(String[] argumentos) {
        this.argumentos = argumentos;
    }

    @Override
    public void executar() {
        int codUsuario = Integer.parseInt(argumentos[1]);
        int codLivro = Integer.parseInt(argumentos[2]);

        ServicoReserva servico = new ServicoReserva();
        servico.reservarLivro(codUsuario, codLivro);
    }
}

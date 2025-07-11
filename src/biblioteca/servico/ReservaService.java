package servico;

import dominio.Livro;
import dominio.Reserva;
import dominio.Usuario;
import repositorio.BibliotecaRepositorio;

import java.time.LocalDate;

public class ReservaService {

    private BibliotecaRepositorio repositorio = BibliotecaRepositorio.getInstancia();

    public void reservarLivro(int codUsuario, int codLivro) {
        Usuario usuario = repositorio.buscarUsuarioPorCodigo(codUsuario);
        Livro livro = repositorio.buscarLivroPorCodigo(codLivro);

        if (usuario == null || livro == null) {
            System.out.println("Usuário ou livro não encontrado.");
            return;
        }

        Reserva reserva = new Reserva(livro, LocalDate.now(), usuario);
        usuario.adicionarReserva(reserva);
        livro.adicionarReserva(reserva);

        System.out.println("Reserva realizada com sucesso.");
    }
}

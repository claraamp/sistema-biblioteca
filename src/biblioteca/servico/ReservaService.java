package biblioteca.servico;

import biblioteca.dominio.Livro;
import biblioteca.dominio.Reserva;
import biblioteca.dominio.Usuario;
import biblioteca.exceptions.ReservaException;

import java.time.LocalDate;

public class ReservaService {

    public Reserva realizarReserva(Usuario usuario, Livro livro) throws ReservaException {

        if (usuario.temEmprestimoDoLivro(livro)) {
            throw new ReservaException("Não foi possível realizar a reserva, pois o usuário não pode reservar um livro que já está em sua posse.");
        }

        if (livro.usuarioTemReserva(usuario)) {
            throw new ReservaException("Não foi possível realizar a reserva, pois o usuário já possui uma reserva para este livro.");
        }

        Reserva novaReserva = new Reserva(livro, LocalDate.now(), usuario);

        usuario.adicionarReserva(novaReserva);
        livro.adicionarReserva(novaReserva);

        return novaReserva;
    }
}

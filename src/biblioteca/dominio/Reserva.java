package biblioteca.dominio;

import java.time.LocalDate;

public class Reserva {
    private Livro livro;
    private LocalDate dataReserva;
    private Usuario usuario;

    public Reserva(Livro livro, LocalDate dataReserva, Usuario usuario) {
        this.livro = livro;
        this.dataReserva = dataReserva;
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}

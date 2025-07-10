package biblioteca.dominio;

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Usuario usuario;
    private Exemplar exemplar;


    public Emprestimo(Usuario usuario, Exemplar exemplar,  LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }
}

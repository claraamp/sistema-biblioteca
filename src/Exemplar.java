public class Exemplar {
    private String codigoExemplar;
    private Livro livro;
    private Emprestimo emprestimoCorrente;


    public Exemplar(String codigoExemplar, Livro livro) {
        this.codigoExemplar = codigoExemplar;
        this.livro = livro;
        this.emprestimoCorrente = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public Emprestimo getEmprestimoCorrente() {
        return emprestimoCorrente;
    }

    public void setEmprestimoCorrente(Emprestimo emprestimoCorrente) {
        this.emprestimoCorrente = emprestimoCorrente;
    }

    public boolean isEmprestado() {
        return this.emprestimoCorrente != null;
    }
}

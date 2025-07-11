package biblioteca.dominio;

public class Exemplar {
    private String codigo;
    private Livro livro;
    private Emprestimo emprestimoCorrente;


    public Exemplar(String codigo, Livro livro) {
        this.codigo = codigo;
        this.livro = livro;
        this.emprestimoCorrente = null;
    }

    public String getCodigo() { return codigo; }

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

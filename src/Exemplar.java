public class Exemplar {
    private String codigoExemplar;
    private Livro livro;
    private boolean statusExemplar;
    private Emprestimo emprestimo;


    public Exemplar(String codigoExemplar, Livro livro) {
        this.codigoExemplar = codigoExemplar;
        this.livro = livro;
    }
}

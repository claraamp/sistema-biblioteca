import java.util.List;

public class Livro {
    private String idLivro;
    private String titulo;
    private String editora;
    private List<String> autores;
    private String edicao;
    private int anoDePublicacao;
    private List<Exemplar> exemplares;
    private List<Reserva> reservas;

    public Livro(String idLivro, String titulo, String editora, List<String> autores, String edicao, int anoDePublicacao) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoDePublicacao = anoDePublicacao;
    }

}

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private static Repositorio instancia;

    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Livro> livros = new ArrayList<Livro>();

    private Repositorio() {};

    public static Repositorio obterInstancia() {
        if (instancia == null)
            instancia = new Repositorio();
        return instancia;
    }

    public Usuario obterUsuarioPorCodigo(String codigo) {
        return usuarios.get(codigo);
    }

    public Livro obterLivroPorCodigo(String codigo) {
        return null;
    }

}

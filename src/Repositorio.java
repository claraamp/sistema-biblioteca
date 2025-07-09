import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio {

    private static Repositorio instancia;
    private final Map<String, Usuario> usuarios;
    private final Map<String, Livro> livros;

    private Repositorio() {
        this.usuarios = new HashMap<>();
        this.livros = new HashMap<>();
        inicializarDados();
    };

    public static Repositorio obterInstancia() {
        if (instancia == null)
            instancia = new Repositorio();
        return instancia;
    }

    public Usuario buscarUsuarioPorId(String idUsuario) {
        return usuarios.get(idUsuario);
    }

    public Livro buscarLivroPorId(String idLivro) {
        return livros.get(idLivro);
    }

    private void inicializarDados() {
        Usuario u123 = new AlunoGraduacao("123", "João da Silva");
        Usuario u456 = new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues");
        Usuario u789 = new AlunoGraduacao("789", "Pedro Paulo");
        Usuario u100 = new Professor("100", "Carlos Lucena");

        this.usuarios.put(u123.getIdUsuario(), u123);
        this.usuarios.put(u456.getIdUsuario(), u456);
        this.usuarios.put(u789.getIdUsuario(), u789);
        this.usuarios.put(u100.getIdUsuario(), u100);

        Livro l100 = new Livro("100", "Engenharia de Software", "Addison Wesley", List.of("Ian Sommervile"), "6ª", 2000);
        Livro l101 = new Livro("101", "UML - Guia do Usuário", "Campus", List.of("Grady Booch, James Rumbaugh, Ivar Jacobson"), "7ª", 2000);
        Livro l200 = new Livro("200", "Code Complete", "Microsoft Press", List.of("Steve McConnell"), "2ª", 2014);
        Livro l201 = new Livro("201", "Agile Software Development, Principles, Patterns and Practices", "Prentice Hall", List.of("Robert Martin"), "1ª", 2002);
        Livro l300 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", List.of("Martin Fowler"), "1ª", 1999);
        Livro l301 = new Livro("301", "Software Metrics: A rigorous and Practical Approach", "CRC Press", List.of("Norman Fenton, James Bieman"), "3ª", 2014);
        Livro l400 = new Livro("400", "Design Patterns: Element of Reusable Object-Oriented Software", "Addison Wesley Professional", List.of("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"), "1ª", 1994);
        Livro l401 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", List.of("Martin Fowler"), "3ª", 2003);

        this.livros.put(l100.getIdLivro(), l100);
        this.livros.put(l101.getIdLivro(), l101);
        this.livros.put(l200.getIdLivro(), l200);
        this.livros.put(l201.getIdLivro(), l201);
        this.livros.put(l300.getIdLivro(), l300);
        this.livros.put(l301.getIdLivro(), l301);
        this.livros.put(l400.getIdLivro(), l400);
        this.livros.put(l401.getIdLivro(), l401);


        l100.adicionarExemplar(new Exemplar("01", l100));
        l100.adicionarExemplar(new Exemplar("02", l100));

        l101.adicionarExemplar(new Exemplar("03", l101));

        l200.adicionarExemplar(new Exemplar("04", l200));

        l201.adicionarExemplar(new Exemplar("05", l201));

        l300.adicionarExemplar(new Exemplar("06", l300));
        l300.adicionarExemplar(new Exemplar("07", l300));

        l400.adicionarExemplar(new Exemplar("08", l400));
        l400.adicionarExemplar(new Exemplar("09", l400));


        System.out.println("Repositório inicializado com os dados de teste.");
    }
}

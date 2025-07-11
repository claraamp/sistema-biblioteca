package biblioteca.repositorio;


import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.dominio.AlunoGraduacao;
import biblioteca.dominio.AlunoPosGraduacao;
import biblioteca.dominio.Professor;
import biblioteca.dominio.Exemplar;


import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private static Repositorio instancia;
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private List<Livro> livros = new ArrayList<Livro>();

    private Repositorio() {
        inicializarDados();
    };

    public static Repositorio obterInstancia() {
        if (instancia == null)
            instancia = new Repositorio();
        return instancia;
    }

    public Usuario buscarUsuarioPorCodigo(String codigo) {
        return usuarios.stream()
                .filter(u -> u.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public Livro buscarLivroPorCodigo(String codigo) {
        return livros.stream()
                .filter(l -> l.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }


    private void inicializarDados() {

        usuarios.add(new AlunoGraduacao("123", "João da Silva"));
        usuarios.add(new AlunoPosGraduacao("456", "Luiz Fernando Rodrigues"));
        usuarios.add(new AlunoGraduacao("789", "Pedro Paulo"));
        usuarios.add(new Professor("100", "Carlos Lucena"));

        Livro l100 = new Livro("100", "Engenharia de Software", "Addison Wesley", List.of("Ian Sommervile"), "6ª", 2000);
        Livro l101 = new Livro("101", "UML - Guia do Usuário", "Campus", List.of("Grady Booch, James Rumbaugh, Ivar Jacobson"), "7ª", 2000);
        Livro l200 = new Livro("200", "Code Complete", "Microsoft Press", List.of("Steve McConnell"), "2ª", 2014);
        Livro l201 = new Livro("201", "Agile Software Development, Principles, Patterns and Practices", "Prentice Hall", List.of("Robert Martin"), "1ª", 2002);
        Livro l300 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", List.of("Martin Fowler"), "1ª", 1999);
        Livro l301 = new Livro("301", "Software Metrics: A rigorous and Practical Approach", "CRC Press", List.of("Norman Fenton, James Bieman"), "3ª", 2014);
        Livro l400 = new Livro("400", "Design Patterns: Element of Reusable Object-Oriented Software", "Addison Wesley Professional", List.of("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"), "1ª", 1994);
        Livro l401 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", List.of("Martin Fowler"), "3ª", 2003);

        l100.adicionarExemplar(new Exemplar("01", l100));
        l100.adicionarExemplar(new Exemplar("02", l100));
        l101.adicionarExemplar(new Exemplar("03", l101));
        l200.adicionarExemplar(new Exemplar("04", l200));
        l201.adicionarExemplar(new Exemplar("05", l201));
        l300.adicionarExemplar(new Exemplar("06", l300));
        l300.adicionarExemplar(new Exemplar("07", l300));
        l400.adicionarExemplar(new Exemplar("08", l400));
        l400.adicionarExemplar(new Exemplar("09", l400));

        livros.add(l100);
        livros.add(l101);
        livros.add(l200);
        livros.add(l201);
        livros.add(l300);
        livros.add(l400);
    }


}

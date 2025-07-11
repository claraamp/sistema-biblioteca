package biblioteca.comando;


import biblioteca.servico.EmprestimoService;
import biblioteca.repositorio.Repositorio;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.excecao.EmprestimoException;
import biblioteca.dominio.Emprestimo;


public class EmprestimoComando implements IComando {

    private final EmprestimoService emprestimoService;
    private final String idUsuario;
    private final String idLivro;

    public EmprestimoComando(EmprestimoService emprestimoService, String idUsuario, String idLivro) {
        this.emprestimoService = emprestimoService;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
    }

    @Override
    public void execute() {
        Repositorio repositorio = Repositorio.obterInstancia();
        Usuario usuario = repositorio.buscarUsuarioPorId(idUsuario);
        Livro livro = repositorio.buscarLivroPorId(idLivro);

        if (usuario == null) {
            System.out.println("Erro: Usuário com código '" + idUsuario + "' não encontrado.");
            return;
        }

        if (livro == null) {
            System.out.println("Erro: Livro com código '" + idLivro + "' não encontrado.");
            return;
        }

        try {
            Emprestimo emprestimo = emprestimoService.realizarEmprestimo(usuario, livro);

            System.out.println("Empréstimo realizado!");
            System.out.println("  - Usuário: " + usuario.getNome() + " (" + usuario.getIdUsuario() + ")");
            System.out.println("  - Livro: " + livro.getTitulo() + " (" + livro.getIdLivro() + ")");
            System.out.println("  - Data para devolução: " + emprestimo.getDataDevolucao());

        } catch (EmprestimoException e) {
            System.out.println(e.getMessage());
        }
    }
}

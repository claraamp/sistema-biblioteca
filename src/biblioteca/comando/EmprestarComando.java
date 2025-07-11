package biblioteca.comando;

import biblioteca.servico.EmprestimoService;
import biblioteca.repositorio.Repositorio;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.excecao.EmprestimoException;
import biblioteca.dominio.Emprestimo;


public class EmprestarComando implements Comando {

    public EmprestarComando() {}

    @Override
    public void execute(CarregadorParametros carregadorParametros) {
        String codigoUsuario = carregadorParametros.getParametroUm();
        String codigoLivro = carregadorParametros.getParametroDois();

        EmprestimoService emprestimoService = new EmprestimoService();

        Repositorio repositorio = Repositorio.obterInstancia();
        Usuario usuario = repositorio.buscarUsuarioPorCodigo(codigoUsuario);
        Livro livro = repositorio.buscarLivroPorCodigo(codigoLivro);

        if (usuario == null) {
            System.out.println("Erro: Usuário com código '" + codigoUsuario + "' não encontrado.");
            return;
        }

        if (livro == null) {
            System.out.println("Erro: Livro com código '" + codigoLivro + "' não encontrado.");
            return;
        }

        try {
            Emprestimo emprestimo = emprestimoService.realizarEmprestimo(usuario, livro);

            System.out.println("Empréstimo realizado!");
            System.out.println("  - Usuário: " + usuario.getNome() + " (" + usuario.getCodigo() + ")");
            System.out.println("  - Livro: " + livro.getTitulo() + " (" + livro.getCodigo() + ")");
            System.out.println("  - Data para devolução: " + emprestimo.getDataDevolucao());

        } catch (EmprestimoException e) {
            System.out.println(e.getMessage());
        }
    }
}


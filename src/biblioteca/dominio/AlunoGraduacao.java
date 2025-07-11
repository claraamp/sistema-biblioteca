package biblioteca.dominio;

import biblioteca.regras.RegraEmprestimoAluno;

public class AlunoGraduacao extends Usuario{

    public AlunoGraduacao(String codigo, String nome) {
        super(codigo, nome);
        this.regraEmprestimo = new RegraEmprestimoAluno();
    }

    @Override
    public int getTempoEmprestimo() {
        return 4;
    }

    @Override
    public int getLimiteEmprestimosAberto() {
        return 2;
    }
}

package biblioteca.dominio;

import biblioteca.regras.RegraEmprestimoAluno;

public class AlunoPosGraduacao extends Usuario{

    public AlunoPosGraduacao(String idUsuario, String nome) {
        super(idUsuario, nome);
        this.regraEmprestimo = new RegraEmprestimoAluno();
    }

    @Override
    public int getTempoEmprestimo() {
        return 5;
    }

    @Override
    public int getLimiteEmprestimosAberto() {
        return 3;
    }
}

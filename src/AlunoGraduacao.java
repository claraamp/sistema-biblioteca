public class AlunoGraduacao extends Usuario{

    public AlunoGraduacao(String idUsuario, String nome) {
        super(idUsuario, nome);
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

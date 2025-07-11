package biblioteca.dominio;

import biblioteca.regras.RegraEmprestimoProfessor;

public class Professor extends Usuario{

    public Professor(String idUsuario, String nome) {
        super(idUsuario, nome);
        this.regraEmprestimo = new RegraEmprestimoProfessor();
    }
    @Override
    public int getTempoEmprestimo() {
        return 8;
    }

    @Override
    public int getLimiteEmprestimosAberto() {
        return Integer.MAX_VALUE;
    }
}

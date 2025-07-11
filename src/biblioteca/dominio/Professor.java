package biblioteca.dominio;

import biblioteca.regras.RegraEmprestimoProfessor;

public class Professor extends Usuario{

    public Professor(String codigo, String nome) {
        super(codigo, nome);
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

package biblioteca.servico;

import biblioteca.dominio.Emprestimo;
import biblioteca.dominio.Usuario;
import biblioteca.dominio.Livro;
import biblioteca.dominio.Exemplar;
import biblioteca.excecao.EmprestimoException;


import java.time.LocalDate;
import java.util.Optional;

public class EmprestimoService {
    public Emprestimo realizarEmprestimo(Usuario usuario, Livro livro) throws EmprestimoException {

        usuario.getRegraEmprestimo().validaEmprestimo(usuario, livro);

        Optional<Exemplar> exemplarDisponivelOpt = livro.getExemplarDisponivel();

        Exemplar exemplar = exemplarDisponivelOpt.get();

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusDays(usuario.getTempoEmprestimo());

        Emprestimo novoEmprestimo = new Emprestimo(usuario, exemplar, dataEmprestimo, dataDevolucao);

        usuario.adicionarEmprestimo(novoEmprestimo);
        exemplar.setEmprestimoCorrente(novoEmprestimo);

        if (livro.usuarioTemReserva(usuario)) {
            livro.removerReservaParaUsuario(usuario);
        }

        return novoEmprestimo;
    }
}
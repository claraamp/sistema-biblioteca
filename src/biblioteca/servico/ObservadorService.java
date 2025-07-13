package biblioteca.servico;

import biblioteca.dominio.Livro;
import biblioteca.dominio.Professor;
import biblioteca.dominio.Usuario;
import biblioteca.exceptions.ObservadorException;

public class ObservadorService {
    public void registrarObservador(Usuario usuario, Livro livro) throws ObservadorException {
//        if (!(usuario instanceof Professor)) {
//            throw new ObservadorException("Apenas professores podem se registrar como observadores de livros.");
//        }

        if (livro.getObservadores().contains(usuario)) {
            throw new ObservadorException("Usuário '" + usuario.getNome() + "' já é um observador deste livro.");
        }
        livro.registrarObservador(usuario);
    }
}

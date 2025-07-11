package biblioteca;

import biblioteca.comando.*;

import java.util.HashMap;
import java.util.Scanner;

public class InterfaceUsuario {

    private HashMap<String, Comando> comandos = new HashMap<>();

    public InterfaceUsuario() {
        inicializarComandos();
    }

    private void inicializarComandos() {
        comandos.put("emp", new EmprestarComando());
        comandos.put("dev", new DevolverComando());
        comandos.put("res", new ReservarComando());
        //comandos.put("obs", new )
        comandos.put("liv", new ConsultarLivroComando());
        //comandos.put("usu", new ConsultarUsuarioComando());
        //comandos.put("ntf", new );

    }

    public void executarComando(String strComando, CarregadorParametros parametros) {
        Comando comando = comandos.get(strComando);
        if (comando != null) {
            comando.execute(parametros);
        } else {
            System.out.println("Erro: Comando desconhecido '" + strComando + "'.");
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Sistema de Biblioteca ---");
        System.out.println("Comandos disponíveis:");
        System.out.println("  > Para realizar um empréstimo, digite: emp <cod_usuario> <cod_livro>");
        System.out.println("  > Para realizar uma devolução, digite: dev <cod_usuario> <cod_livro>");
        System.out.println("  > Para realizar uma reserva, digite: res <cod_usuario> <cod_livro>");
        System.out.println("  > Para observar um livro, digite: obs <cod_usuario> <cod_livro>");
        System.out.println("  > Para consultar um livro, digite: liv <cod_livro>");
        System.out.println("  > Para consultar um usuario, digite: usu <cod_usuario>");
        System.out.println("  > Para consultar as notificações de um usuario, digite: ntf <cod_usuario>");
        System.out.println("  > Para encerrar o sistema, digite: sai");

        while (true) {
            System.out.print("\nComando> ");
            String linha = scanner.nextLine();
            String[] partes = linha.trim().split("\\s+");
            String nomeComando = partes[0].toLowerCase();

            if ("sai".equals(nomeComando)) {
                System.out.println("Encerrando o sistema.");
                break;
            }

            CarregadorParametros parametros = null;
            if (partes.length == 2) {
                parametros = new CarregadorParametros(partes[1]);
            } else if (partes.length == 3) {
                parametros = new CarregadorParametros(partes[1], partes[2]);
            } else if (partes.length > 3) {
                System.out.println("Erro: Número de parâmetros inválido.");
                continue;
            }

            executarComando(nomeComando, parametros);
        }
        scanner.close();
    }
}

package biblioteca;

import biblioteca.servico.DevolucaoService;
import biblioteca.servico.EmprestimoService;
import biblioteca.repositorio.Repositorio;
import biblioteca.comando.*;

import java.util.Scanner;

public class SistemaBiblioteca {

    private final EmprestimoService emprestimoService;
    private DevolucaoService devolucaoService;

    public SistemaBiblioteca() {
        this.emprestimoService = new EmprestimoService();
        this.devolucaoService = new DevolucaoService();
    }


    public void iniciar() {
        Repositorio.obterInstancia();

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

            if ("sai".equalsIgnoreCase(linha.trim())) {
                System.out.println("Encerrando o sistema.");
                break;
            }

            if (linha.trim().isEmpty()) {
                continue;
            }

            processarComando(linha);
        }
        scanner.close();
    }

    private void processarComando(String linha) {
        String[] partes = linha.trim().split("\\s+");
        String nomeComando = partes[0].toLowerCase();

        switch (nomeComando) {
            case "emp":
                if (partes.length != 3) {
                    System.out.println("Erro: Formato incorreto. Use: emp <cod_usuario> <cod_livro>");
                    break;
                }
                IComando comandoEmp = new EmprestimoComando(this.emprestimoService, partes[1], partes[2]);
                comandoEmp.execute();
                break;

            case "dev":
                if (partes.length != 3) {
                    System.out.println("Erro: Formato incorreto. Use: dev <cod_usuario> <cod_livro>");
                    break;
                }
                IComando comandoDev = new DevolucaoComando(this.devolucaoService, partes[1], partes[2]);
                comandoDev.execute();
                break;

            case "res":
                if (partes.length != 3) {
                    System.out.println("Erro: Formato incorreto. Use: res <cod_usuario> <cod_livro>");
                    break;
                }
                System.out.println("INFO: Funcionalidade 'reserva' ainda não implementada.");
                break;

            case "obs":
                if (partes.length != 3) {
                    System.out.println("Erro: Formato incorreto. Use: obs <cod_usuario> <cod_livro>");
                    break;
                }
                System.out.println("INFO: Funcionalidade 'observador' ainda não implementada.");
                break;

            case "liv":
                if (partes.length != 2) {
                    System.out.println("ERRO: Formato incorreto. Use: liv <cod_livro>");
                    break;
                }
                IComando comandoLiv = new ConsultaLivroComando(partes[1]);
                comandoLiv.execute();
                break;

            case "usu":
                if (partes.length != 2) {
                    System.out.println("Erro: Formato incorreto. Use: usu <cod_usuario>");
                    break;
                }
                System.out.println("INFO: Funcionalidade 'consultar usuário' ainda não implementada.");
                break;

            case "ntf":
                if (partes.length != 2) {
                    System.out.println("Erro: Formato incorreto. Use: ntf <cod_usuario>");
                    break;
                }
                System.out.println("INFO: Funcionalidade 'notificações' ainda não implementada.");
                break;

            default:
                System.out.println("Erro: Comando desconhecido '" + nomeComando + "'.");
                break;
        }
    }
}

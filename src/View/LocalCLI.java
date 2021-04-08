package View;

import java.util.Scanner;

public class LocalCLI {
    public static void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "\n== * == Menu de Local == * ==\n"+
                        "[1] Listar todos;\n"+
                        "[2] Listar um;\n"+
                        "[3] Incluir;\n"+
                        "[4] Excluir;\n"+
                        "[5] Editar;\n"+
                        "[6] Voltar\n"
        );

        System.out.printf("Digite sua opcao: ");
        String opcao = scanner.nextLine();

        switch (opcao){
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
            case "3":
                System.out.println("3");
                break;
            case "4":
                System.out.println("4");
                break;
            case "5":
                System.out.println("5");
                break;
            case "6":
                break;
            default:
                System.out.println("Opcao invalida! Digite um numero entre 1 e 5\n");
                run();
        }

    }
}

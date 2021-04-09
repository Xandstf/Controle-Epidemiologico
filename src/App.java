import DAOs.localDAO;
import DAOs.pragaDAO;
import Entities.Praga;
import View.LocalCLI;
import View.PragaCLI;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        pragaDAO pragaLista = new pragaDAO();
        localDAO localLista = new localDAO();
        menuPrincipal();
    }

    private static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(
                "\n== * == Menu do Sistema == * ==\n"+
                "[1] Submenu de Local;\n"+
                "[2] Submenu de Praga;\n"+
                "[3] Sair\n"
        );

        System.out.printf("Digite sua opcao: ");
        String opcao = scanner.nextLine();

        switch (opcao){
            case "1":
                LocalCLI.run();
                menuPrincipal();
                break;
            case "2":
                PragaCLI.run();
                menuPrincipal();
                break;
            case "3":
                System.out.println("Obrigado! Progama finalizado.");
                break;
            default:
                System.out.println("Opcao invalida! Digite um numero entre 1 e 5\n");
                menuPrincipal();
        }
    }
}

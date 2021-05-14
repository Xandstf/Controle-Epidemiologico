package UseCases.PragaUseCases;

import DAOs.pragaDAO;

import java.util.Scanner;

public class listarTodosPraga {

    public static void listarTodos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n**** == **** Lista de Pragas **** == ****\n");
        pragaDAO.listarTodosPraga();
        System.out.printf("\nPressione 'enter' para voltar...");
        scanner.nextLine();

    }
}

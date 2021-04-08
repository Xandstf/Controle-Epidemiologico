package UseCases.LocalUseCases;

import DAOs.localDAO;
import java.util.Scanner;

public class listarTodosLocal {

    public static void listarTodos(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n**** == **** Lista de Locais **** == ****\n");
        localDAO.listarTodosLocal();
        System.out.printf("\nPressione 'enter' para voltar...");
        scanner.nextLine();
    }
}

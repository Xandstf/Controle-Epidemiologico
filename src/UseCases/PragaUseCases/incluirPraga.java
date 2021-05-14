package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;

import java.util.Scanner;

public class incluirPraga {

    public static boolean incluir() {
        Scanner scanner = new Scanner(System.in);
        Praga praga = new Praga();

        System.out.printf("Codigo: ");
        int codigo = scanner.nextInt();
        while (pragaDAO.listarUmPraga(codigo) != null) {
            System.out.println("\n** Este codigo já esta em uso no sistema!\n");
            System.out.printf("Codigo: ");
            codigo = scanner.nextInt();
        }
        praga.setCodigo(codigo);
        scanner.nextLine();
        System.out.printf("Nome: ");
        praga.setNome(scanner.nextLine());
        System.out.printf("Doencas Transimitidas: ");
        praga.setDoencas_Transimitidas(scanner.nextLine());
        System.out.printf("Tempo de Vida (Dias): ");
        praga.setTempo_Vida(scanner.nextInt());
        System.out.printf("Modos de Combate: ");
        praga.setModos_Combate(scanner.nextLine());

        return pragaDAO.incluirPraga(praga);
    }
}

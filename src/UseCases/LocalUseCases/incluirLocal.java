package UseCases.LocalUseCases;

import DAOs.localDAO;
import Entities.Local;

import java.util.Scanner;

public class incluirLocal {

    public static boolean incluir() {
        Scanner scanner = new Scanner(System.in);
        Local local = new Local();

        System.out.printf("CEP: ");
        String CEP = scanner.nextLine();
        while (localDAO.listarUmLocal(CEP) != null) {
            System.out.println("\n** Este CEP já esta em uso no sistema!\n");
            System.out.printf("CEP: ");
            CEP = scanner.nextLine();
        }
        local.setCEP_ponto_central(CEP);
        System.out.printf("Raio: ");
        local.setRaio(scanner.nextInt());
        System.out.printf("População: ");
        local.setPopulacao(scanner.nextInt());
        scanner.nextLine();
        System.out.printf("Caracteristicas: ");
        local.setCaracteristicas(scanner.nextLine());
        System.out.printf("Telefone defesa civil: ");
        local.setTelefone_defesaCivil(scanner.nextLine());

        return localDAO.incluirLocal(local);
    }
}

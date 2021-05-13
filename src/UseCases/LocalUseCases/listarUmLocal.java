package UseCases.LocalUseCases;

import DAOs.localDAO;
import Entities.Local;

import java.util.Scanner;

public class listarUmLocal {

    public static void listarUm() {
        Scanner scanner = new Scanner(System.in);


        System.out.printf("\nDigite o CEP do local que deseja visualizar: ");
        String codigo = scanner.nextLine();

        if (localDAO.listarUmLocal(codigo) != null) {
            Local local = localDAO.listarUmLocal(codigo);
            System.out.println("\n\n**** == **** Informações sobre o Local **** == ****\n");
            System.out.println(
                    "CEP: " + local.getCEP_ponto_central() +
                            "\nRaio: " + local.getRaio() +
                            "\nPopulação: " + local.getPopulacao() +
                            "\nCaracteristicas: " + local.getCaracteristicas() +
                            "\nTelefone defese civil: " + local.getTelefone_defesaCivil()
            );
            System.out.printf("\nPressione 'enter' para voltar...\n");
            scanner.nextLine();
        } else {
            System.out.println("\n** Local não encontrada. Liste todos para obter seus respectivos CEPs.");
        }

    }
}

package UseCases.LocalUseCases;

import DAOs.localDAO;
import DAOs.pragaDAO;
import Entities.Local;
import Entities.Praga;

import java.util.Scanner;

public class incluirLocal {

    public static boolean incluir(){
        Scanner scanner = new Scanner(System.in);
        Local local = new Local();

        System.out.printf("CEP: ");
        local.setCEP_ponto_central(scanner.nextLine());
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

package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;
import java.util.Scanner;

public class incluirPraga {

    public static boolean incluir(){
        Scanner scanner = new Scanner(System.in);
        Praga praga = new Praga();

        System.out.printf("Codigo: ");
        praga.setCodigo(scanner.nextInt());
        scanner.nextLine();
        System.out.printf("Nome: ");
        praga.setNome(scanner.nextLine());
        System.out.printf("Doencas Transimitidas: ");
        praga.setDoencas_Transimitidas(scanner.nextLine());
        System.out.printf("Tempo de Vida (Dias): ");
        praga.setTempo_Vida(scanner.nextLine());
        System.out.printf("Modos de Combate: ");
        praga.setModos_Combate(scanner.nextLine());

        return pragaDAO.incluirPraga(praga);
    }
}

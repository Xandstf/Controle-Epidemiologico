package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;

import java.util.Scanner;

public class excluirPraga {

    public static void excluir(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nDigite o codigo da praga que deseja excluir: ");
        int codigo = scanner.nextInt();

        if(pragaDAO.excluirPraga(codigo)){
            System.out.println("\n** Praga excluida com sucesso!");
        }else{
            System.out.println("\n** Praga não encontrada. Liste todas para obter seus respectivos codigos.");
        }
    }
}

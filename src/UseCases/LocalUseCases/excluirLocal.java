package UseCases.LocalUseCases;

import DAOs.localDAO;
import DAOs.pragaDAO;

import java.util.Scanner;

public class excluirLocal {

    public static void excluir(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nDigite o CEP do local que deseja excluir: ");
        String codigo = scanner.nextLine();

        if(localDAO.excluirLocal(codigo)){
            System.out.println("\n** Local excluida com sucesso!");
        }else{
            System.out.println("\n** Local não encontrado. Liste todos para obter seus respectivos CEPs.");
        }
    }
}

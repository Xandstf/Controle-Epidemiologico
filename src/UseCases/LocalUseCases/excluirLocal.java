package UseCases.LocalUseCases;

import DAOs.localDAO;
import DAOs.pragaDAO;

import java.util.Scanner;

public class excluirLocal {

    public static void excluir(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nDigite o CEP do local que deseja excluir: ");
        String codigo = scanner.nextLine();

        System.out.print("Você tem certeza que deseja excluir? (S/N): ");
        String confirmacao = scanner.nextLine();
        if(confirmacao.equals("S")){
            if(localDAO.excluirLocal(codigo)){
                System.out.println("\n** Local excluido com sucesso!");
            }else{
                System.out.println("\n** Local não encontrado. Liste todos para obter seus respectivos CEPs.");
            }
        }else{
            System.out.println("\n** Ação cancelada!");
        }
    }

    public static void excluir(String codigo, String confirmacao){
        if(confirmacao.equals("S")){
            if(localDAO.excluirLocal(codigo)){
                System.out.println("\n** Local excluido com sucesso!");
            }else{
                System.out.println("\n** Local não encontrado. Liste todos para obter seus respectivos CEPs.");
            }
        }else{
            System.out.println("\n** Ação cancelada!");
        }
    }
}

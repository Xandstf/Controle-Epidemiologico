package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;

import java.util.Scanner;

public class listarUmPraga {

    public static void listarUm(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nDigite o codigo da praga que deseja visualizar: ");
        int codigo = scanner.nextInt();

        if(pragaDAO.listarUmPraga(codigo)!=null){
            Praga praga = pragaDAO.listarUmPraga(codigo);
            System.out.println("\n\n**** == **** Informações sobre a Praga **** == ****\n");
            System.out.println(
                    "Nome: " + praga.getNome()+
                    "\nCodigo: " + praga.getCodigo()+
                    "\nDoenças Transimitidas: " + praga.getDoencas_Transimitidas()+
                    "\nTempo de Vida (Dias): " + praga.getTempo_Vida()+
                    "\nModos de Combate: " + praga.getModos_Combate()
            );
            System.out.printf("\nPressione 'enter' para voltar...\n");
            scanner.nextLine();
            scanner.nextLine();
        }else{
            System.out.println("\n** Praga não encontrada. Liste todas para obter seus respectivos codigos.");
        }

    }
}

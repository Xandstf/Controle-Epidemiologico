package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;

import java.util.Scanner;

public class alterarPraga {

    public static void alterar() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nDigite o codigo da praga que deseja editar: ");
        int codigo = scanner.nextInt();

        if (pragaDAO.listarUmPraga(codigo) != null) {
            Praga praga = pragaDAO.listarUmPraga(codigo);
            System.out.println("\n\n**** == **** Editor de Praga **** == ****\n");
            System.out.println(
                    "Nome: " + praga.getNome() +
                            "\nDoenças Transimitidas: " + praga.getDoencas_Transimitidas() +
                            "\nTempo de Vida (Dias): " + praga.getTempo_Vida() +
                            "\nModos de Combate: " + praga.getModos_Combate()
            );
            scanner.nextLine();
            System.out.print("\nQual informação deseja alterar: \n" +
                    "[1] Nome;\n" +
                    "[2] Doenças Transimitidas;\n" +
                    "[3] Tempo de Vida;\n" +
                    "[4] Modos de Combate\n");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                System.out.print("Digite um novo nome: ");
                pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setNome(scanner.nextLine());
                System.out.print("\n** Nome atualizado com sucesso!\n");
            } else if (opcao == 2) {
                System.out.print("Digite as doenças transmitdas: ");
                pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setDoencas_Transimitidas(scanner.nextLine());
                System.out.print("\n** Doenças Transimitidas atualizadas com sucesso!\n");
            } else if (opcao == 3) {
                System.out.print("Digite o novo tempo de vida: ");
                pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setTempo_Vida(scanner.nextInt());
                System.out.print("\n** Tempo de Vida atualizado com sucesso!\n");
            } else if (opcao == 4) {
                System.out.print("Digite o novo modo de combate: ");
                pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setModos_Combate(scanner.nextLine());
                System.out.print("\n** Modo de Combate atualizado com sucesso!\n");
            } else {
                System.out.println("** Opção invalida! Digite um dos nomes dos atributos.");
            }
        } else {
            System.out.println("\n** Praga não encontrada. Liste todas para obter seus respectivos codigos.");
        }
    }

    public static void alterar(int codigo, String opcao, String modificacao) {

        if (pragaDAO.listarUmPraga(codigo) != null) {
            Praga praga = pragaDAO.listarUmPraga(codigo);
            if (opcao.equals("nome")) {
                pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setNome(modificacao);
                System.out.print("\n** Nome atualizado com sucesso!\n");
            } else if (opcao.equals("doenças transmitidas")) {
                pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setDoencas_Transimitidas(modificacao);
                System.out.print("\n** Doenças Transimitidas atualizadas com sucesso!\n");
            } else if (opcao.equals("tempo de vida")) {
                try {
                    int tempo = Integer.parseInt(modificacao);
                    pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setTempo_Vida(tempo);
                    System.out.print("\n** Tempo de Vida atualizado com sucesso!\n");
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                }
            } else if (opcao.equals("modos de combate")) {
                pragaDAO.pragaArrayList.get(pragaDAO.pragaArrayList.indexOf(praga)).setModos_Combate(modificacao);
                System.out.print("\n** Modo de Combate atualizado com sucesso!\n");
            } else {
                System.out.println("** Opção invalida! Digite um dos nomes dos atributos.");
            }
        } else {
            System.out.println("\n** Praga não encontrada. Liste todas para obter seus respectivos codigos.");
        }
    }
}

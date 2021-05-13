package DAOs;

import Entities.Local;

import java.util.ArrayList;

public class localDAO {
    public static ArrayList<Local> localArrayList = new ArrayList();

    public static boolean incluirLocal(Local local) {
        if (localDAO.listarUmLocal(local.getCEP_ponto_central()) != null) {
            return false;
        }

        if (local.getTelefone_defesaCivil() != null) {
            if (!local.getTelefone_defesaCivil().matches("^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$")) {
                System.out.println("\n** Telefone em formato inválido. Formato correto é: (xx) xxxx-xxxx\n");
                return false;
            }
        }

        if (local.getCEP_ponto_central() != null) {
            int length = local.getCEP_ponto_central().length();
            if (!local.getCEP_ponto_central().matches("^\\d{5}-\\d{3}$")) {
                System.out.println("\n** CEP em formato inválido. Formato correto é: xxxxx-xxx\n");
                return false;
            }
        }

        return localArrayList.add(local);
    }

    public static void listarTodosLocal() {
        for (Local local : localArrayList) {
            System.out.println(local.getCEP_ponto_central());
        }
    }

    public static boolean excluirLocal(String CEP) {
        return localArrayList.removeIf(local -> CEP.equals(local.getCEP_ponto_central()));
    }

    public static Local listarUmLocal(String CEP) {
        for (Local local : localArrayList) {
            if (local.getCEP_ponto_central().equals(CEP)) {
                return local;
            }
        }
        return null;
    }
}

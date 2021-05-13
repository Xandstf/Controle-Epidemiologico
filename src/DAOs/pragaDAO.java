package DAOs;

import Entities.Praga;

import java.util.ArrayList;

public class pragaDAO {
    public static ArrayList<Praga> pragaArrayList = new ArrayList();

    public static boolean incluirPraga(Praga praga) {
        if (pragaDAO.listarUmPraga(praga.getCodigo()) != null) {
            return false;
        }

        if (praga.getNome().equals("")
                || praga.getModos_Combate().equals("")
                || praga.getTempo_Vida() == 0
                || praga.getDoencas_Transimitidas().equals("")) {
            return false;
        }

        if (praga.getNome().isBlank()
                || praga.getModos_Combate().isBlank()
                || praga.getTempo_Vida() == 0
                || praga.getDoencas_Transimitidas().isBlank()) {
            return false;
        }

        return pragaArrayList.add(praga);
    }

    public static void listarTodosPraga() {
        for (Praga praga : pragaArrayList) {
            System.out.println("[" + praga.getCodigo() + "] " + praga.getNome());
        }
    }

    public static boolean excluirPraga(int codigo) {
        return pragaArrayList.removeIf(praga -> codigo == praga.getCodigo());
    }

    public static Praga listarUmPraga(int codigo) {
        for (Praga praga : pragaArrayList) {
            if (praga.getCodigo() == codigo) {
                return praga;
            }
        }
        return null;
    }
}

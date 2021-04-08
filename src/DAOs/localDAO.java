package DAOs;

import Entities.Local;

import java.util.ArrayList;

public class localDAO {
    public static ArrayList<Local> localArrayList = new ArrayList();

    public static boolean incluirLocal(Local local) {
        for (Local locaisExistentes : localArrayList) {
            if(locaisExistentes.getCEP_ponto_central().equals(local.getCEP_ponto_central())){
                System.out.println("\n** Este CEP já esta em uso no sistema!\n");
                return false;
            }
        }
        return localArrayList.add(local);
    }

    public static void listarTodosLocal(){
        for (Local local : localArrayList) {
            System.out.println(local.getCEP_ponto_central());
        }
    }

    public static boolean excluirLocal(String codigo){
        return localArrayList.removeIf(local -> codigo.equals(local.getCEP_ponto_central()));
    }

    public static Local listarUmLocal(String codigo){
        for (Local local : localArrayList) {
            if(local.getCEP_ponto_central().equals(codigo)){
                return local;
            }
        }
        return null;
    }
}

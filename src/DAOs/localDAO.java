package DAOs;

import Entities.Local;

import java.util.ArrayList;

public class localDAO {
    public static ArrayList<Local> localArrayList = new ArrayList();

    public static boolean incluirLocal(Local local) {
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

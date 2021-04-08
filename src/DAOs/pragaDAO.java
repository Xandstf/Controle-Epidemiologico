package DAOs;

import Entities.Local;
import Entities.Praga;
import java.util.ArrayList;

public class pragaDAO {
    public static ArrayList<Praga> pragaArrayList = new ArrayList();

    public static boolean incluirPraga(Praga praga) {
        for (Praga pragasExistentes : pragaArrayList) {
            if(pragasExistentes.getCodigo() == praga.getCodigo()){
                System.out.println("\n** Este codigo já esta em uso no sistema!\n");
                return false;
            }
        }
        return pragaArrayList.add(praga);
    }
    
    public static void listarTodosPraga(){
        for (Praga praga : pragaArrayList) {
            System.out.println("[" + praga.getCodigo() + "] " + praga.getNome());
        }
    }

    public static boolean excluirPraga(int codigo){
        return pragaArrayList.removeIf(praga -> codigo == praga.getCodigo());
    }

    public static Praga listarUmPraga(int codigo){
        for (Praga praga : pragaArrayList) {
            if(praga.getCodigo()==codigo){
                return praga;
            }
        }
        return null;
    }
}

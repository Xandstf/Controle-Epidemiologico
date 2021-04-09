package DAOs;


import Entities.Praga;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class pragaDAOTest {

    public static Praga praga;

    @BeforeAll
    public static void criaObjetoLocal(){
        praga = new Praga();
    }

    @ParameterizedTest
    @ValueSource(strings = {"    ", " ", "\n"})
    @DisplayName("Caso de teste DAO de campos brancos")
    void casoTesteCamposBrancos(String string) {
        praga = new Praga(50, string, string, string, string);
        assertFalse(pragaDAO.incluirPraga(praga));
        pragaDAO.excluirPraga(50);
    }

    @Test
    @DisplayName("Caso de teste DAO de ArrayList de praga")
    public void casoTesteArrayListPraga(){
        ArrayList<Praga> pragaArrayList = new ArrayList();
        pragaDAO.pragaArrayList = new ArrayList();
        praga = new Praga(2, "Anopheles", "Malária", "7 dias", "Local insalubre");
        pragaDAO.incluirPraga(praga);
        pragaArrayList.add(praga);
        praga = new Praga(1, "Anopheles", "Malária", "7 dias", "Local insalubre");
        pragaDAO.incluirPraga(praga);
        pragaArrayList.add(praga);
        assertArrayEquals(pragaDAO.pragaArrayList.toArray(), pragaArrayList.toArray());
    }
}
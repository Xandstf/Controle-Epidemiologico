package UseCases.PragaUseCases;

import DAOs.localDAO;
import DAOs.pragaDAO;
import Entities.Praga;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class incluirPragaTest {

    public static Praga praga;

    @BeforeAll
    public static void criaObjetoPraga(){
        praga = new Praga();
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir praga com todos valores corretos")
    public void casoTesteIncluirPraga(){
        praga = new Praga(2, "Anopheles", "Malária", "7 dias", "Local insalubre");
        assertTrue(pragaDAO.incluirPraga(praga));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir praga com codigo igual")
    public void casoTesteIncluirPragaRepetida(){
        praga = new Praga(1, "Anopheles", "Malária", "7 dias", "Local insalubre");
        assertTrue(pragaDAO.incluirPraga(praga));
        praga = new Praga(1, "Dengue", "Dengue e Zika", "7 dias", "Agua parada");
        assertFalse(pragaDAO.incluirPraga(praga));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir praga com valores nulos")
    public void casoTesteIncluirPragaNula(){
        praga = new Praga(3, "", "", "", "");
        assertFalse(pragaDAO.incluirPraga(praga));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir praga com valores brancos")
    public void casoTesteIncluirPragaValoresBrancos(){
        praga = new Praga(3, " ", "     ", "      ", "  ");
        assertFalse(pragaDAO.incluirPraga(praga));
    }

}
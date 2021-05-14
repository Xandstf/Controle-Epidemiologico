package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class incluirPragaTest {

    public static Praga praga;

    @BeforeAll
    public static void criaObjetoPraga() {
        praga = new Praga();
    }

    @Test
    @Order(1)
    @DisplayName("Caso de teste do método UseCase de incluir praga com todos valores corretos")
    public void casoTesteIncluirPraga() {
        praga = new Praga(2, "Anopheles", "Malária", 7, "Local insalubre");
        assertTrue(pragaDAO.incluirPraga(praga));
    }

    @Test
    @Order(2)
    @DisplayName("Caso de teste do método UseCase de incluir praga com codigo igual")
    public void casoTesteIncluirPragaRepetida() {
        praga = new Praga(1, "Anopheles", "Malária", 7, "Local insalubre");
        assertTrue(pragaDAO.incluirPraga(praga));
        praga = new Praga(1, "Dengue", "Dengue e Zika", 7, "Agua parada");
        assertFalse(pragaDAO.incluirPraga(praga));
    }

    @Test
    @Order(3)
    @DisplayName("Caso de teste do método UseCase de incluir praga com valores nulos")
    public void casoTesteIncluirPragaNula() {
        praga = new Praga(3, "", "", 0, "");
        assertFalse(pragaDAO.incluirPraga(praga));
    }

    @Test
    @Order(4)
    @DisplayName("Caso de teste do método UseCase de incluir praga com valores brancos")
    public void casoTesteIncluirPragaValoresBrancos() {
        praga = new Praga(3, " ", "     ", 0, "  ");
        assertFalse(pragaDAO.incluirPraga(praga));
    }
}
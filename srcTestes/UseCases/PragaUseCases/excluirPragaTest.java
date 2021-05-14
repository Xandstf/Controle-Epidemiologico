package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class excluirPragaTest {
    public static Praga praga;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void criaObjetoPraga() throws FileNotFoundException {
        praga = new Praga();
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @Order(1)
    @DisplayName("Caso de teste do método UseCase de excluir praga com valores corretos")
    public void casoTesteExcluirPraga() {
        praga = new Praga(2, "Anopheles", "Malária", 7, "Local insalubre");
        pragaDAO.incluirPraga(praga);
        assertTrue(pragaDAO.excluirPraga(2));
    }

    @Test
    @Order(2)
    @DisplayName("Caso de teste do método UseCase de excluir praga não existente")
    public void casoTesteExcluirPragaNaoExistente() {
        assertFalse(pragaDAO.excluirPraga(3));
    }

    @Test
    @Order(3)
    @DisplayName("Caso de teste do método UseCase de excluir praga existente com confirmacao positiva")
    public void casoTesteExcluirPragaExistenteTrue() {
        praga = new Praga(10, "Anopheles", "Malária", 7, "Local insalubre");
        pragaDAO.incluirPraga(praga);
        excluirPraga.excluir(10, "S");
        assertFalse(pragaDAO.excluirPraga(10));
    }

    @Test
    @Order(4)
    @DisplayName("Caso de teste do método UseCase de excluir praga não existente com confirmacao positiva")
    public void casoTesteExcluirPragaNaoExistenteTrue() {
        excluirPraga.excluir(10, "S");
        assertEquals("** Praga não encontrada. Liste todas para obter seus respectivos codigos.", outputStreamCaptor.toString().trim());
    }

    @Test
    @Order(5)
    @DisplayName("Caso de teste do método UseCase de excluir praga existente com confirmacao negativa")
    public void casoTesteExcluirPragaExistenteFalse() {
        praga = new Praga(10, "Anopheles", "Malária", 7, "Local insalubre");
        pragaDAO.incluirPraga(praga);
        excluirPraga.excluir(10, "N");
        assertEquals("** Ação cancelada!", outputStreamCaptor.toString().trim());
    }

    @Test
    @Order(6)
    @DisplayName("Caso de teste do método UseCase de excluir praga não existente com confirmacao negativa")
    public void casoTesteExcluirPragaNaoExistenteFalse() {
        excluirPraga.excluir(2, "N");
        assertEquals("** Ação cancelada!", outputStreamCaptor.toString().trim());
    }
}
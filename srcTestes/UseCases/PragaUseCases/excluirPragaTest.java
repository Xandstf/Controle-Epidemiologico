package UseCases.PragaUseCases;

import DAOs.pragaDAO;
import Entities.Praga;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class excluirPragaTest {
    public static Praga praga;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void criaObjetoPraga() throws FileNotFoundException {
        praga = new Praga();
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de excluir praga com valores corretos")
    public void casoTesteExcluirPraga(){
        praga = new Praga(2, "Anopheles", "Malária", "7 dias", "Local insalubre");
        pragaDAO.incluirPraga(praga);
        assertTrue(pragaDAO.excluirPraga(2));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de excluir praga não existente")
    public void casoTesteExcluirPragaNaoExistente(){
        assertFalse(pragaDAO.excluirPraga(3));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de excluir praga existente com confirmacao positiva")
    public void casoTesteExcluirPragaExistenteTrue(){
        praga = new Praga(10, "Anopheles", "Malária", "7 dias", "Local insalubre");
        pragaDAO.incluirPraga(praga);
        excluirPraga.excluir(10, "S");
        assertFalse(pragaDAO.excluirPraga(10));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de excluir praga não existente com confirmacao positiva")
    public void casoTesteExcluirPragaNaoExistenteTrue(){
        excluirPraga.excluir(10, "S");
        assertEquals("** Praga não encontrada. Liste todas para obter seus respectivos codigos.", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de excluir praga existente com confirmacao negativa")
    public void casoTesteExcluirPragaExistenteFalse(){
        praga = new Praga(10, "Anopheles", "Malária", "7 dias", "Local insalubre");
        pragaDAO.incluirPraga(praga);
        excluirPraga.excluir(10, "N");
        assertEquals("** Ação cancelada!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de excluir praga não existente com confirmacao negativa")
    public void casoTesteExcluirPragaNaoExistenteFalse(){
        excluirPraga.excluir(2, "N");
        assertEquals("** Ação cancelada!", outputStreamCaptor.toString().trim());
    }
}
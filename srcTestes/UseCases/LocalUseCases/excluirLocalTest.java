package UseCases.LocalUseCases;

import DAOs.localDAO;
import Entities.Local;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class excluirLocalTest {

    public static Local local;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    public static void criaObjetoPraga() throws FileNotFoundException {
        local = new Local();
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @Order(1)
    @DisplayName("Caso de teste do método UseCase de excluir local com valores corretos")
    public void casoTesteExcluirPraga() {
        local = new Local("14110-000", 100, 140000, "Cidade pequena", "(16) 3972-2222");
        localDAO.incluirLocal(local);
        assertTrue(localDAO.excluirLocal("14110-000"));
    }

    @Test
    @Order(2)
    @DisplayName("Caso de teste do método UseCase de excluir local não existente")
    public void casoTesteExcluirLocalNaoExistente() {
        assertFalse(localDAO.excluirLocal("14110-000"));
    }

    @Test
    @Order(3)
    @DisplayName("Caso de teste do método UseCase de excluir local existente com confirmacao positiva")
    public void casoTesteExcluirLocalExistenteTrue() {
        local = new Local("14110-000", 100, 140000, "Cidade pequena", "(16) 3972-2222");
        localDAO.incluirLocal(local);
        excluirLocal.excluir("14110-000", "S");
        assertFalse(localDAO.excluirLocal("14110-000"));
    }

    @Test
    @Order(4)
    @DisplayName("Caso de teste do método UseCase de excluir local não existente com confirmacao positiva")
    public void casoTesteExcluirLocalNaoExistenteTrue() {
        excluirLocal.excluir("14110-212", "S");
        assertEquals("** Local não encontrado. Liste todos para obter seus respectivos CEPs.", outputStreamCaptor.toString().trim());
    }

    @Test
    @Order(5)
    @DisplayName("Caso de teste do método UseCase de excluir local existente com confirmacao negativa")
    public void casoTesteExcluirLocalExistenteFalse() {
        local = new Local("14110-000", 100, 140000, "Cidade pequena", "(16) 3972-2222");
        localDAO.excluirLocal("14110-000");
        excluirLocal.excluir("14110-000", "N");
        assertEquals("** Ação cancelada!", outputStreamCaptor.toString().trim());
    }

    @Test
    @Order(6)
    @DisplayName("Caso de teste do método UseCase de excluir local não existente com confirmacao negativa")
    public void casoTesteExcluirPragaNaoExistenteFalse() {
        excluirLocal.excluir("14110-009", "N");
        assertEquals("** Ação cancelada!", outputStreamCaptor.toString().trim());
    }

}
package DAOs;

import Entities.Local;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class localDAOTest {

    public static Local local;

    @BeforeAll
    public static void criaObjetoLocal() {
        local = new Local();
    }

    @ParameterizedTest
    @Order(1)
    @ValueSource(strings = {"(16) 3253-2111", "(16) 3254-2119", "(16) 2254-2111"})
    @DisplayName("Caso de teste DAO de telefones validos")
    void casoTesteTelefonesValidos(String string) {
        local = new Local("14110-222", 100, 140000, "Cidade pequena", string);
        assertTrue(localDAO.incluirLocal(local));
        localDAO.excluirLocal("14110-222");
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(strings = {"(16)3253-2111", "(16) 32542119", "16 2254-2111", "16 224-2111", "(16) 224-2111"})
    @DisplayName("Caso de teste DAO de telefones incorretos")
    void casoTesteTelefonesIncorretos(String string) {
        local = new Local("14110-222", 100, 140000, "Cidade pequena", string);
        assertFalse(localDAO.incluirLocal(local));
        localDAO.excluirLocal("14110-222");
    }

    @ParameterizedTest
    @Order(3)
    @ValueSource(strings = {"14222-111", "14222-112", "14322-111"})
    @DisplayName("Caso de teste DAO de CEPs")
    void casoTesteCEPValidos(String string) {
        local = new Local(string, 100, 140000, "Cidade pequena", "(16) 3253-2111");
        assertTrue(localDAO.incluirLocal(local));
        localDAO.excluirLocal(string);
    }

    @ParameterizedTest
    @Order(3)
    @ValueSource(strings = {"14222111", "1222-112", "14322-11"})
    @DisplayName("Caso de teste DAO de CEPs")
    void casoTesteCEPInvalidos(String string) {
        local = new Local(string, 100, 140000, "Cidade pequena", "(16) 3253-2111");
        assertFalse(localDAO.incluirLocal(local));
    }

    @Test
    @Order(4)
    @DisplayName("Caso de teste DAO de ArrayList de local")
    public void casoTesteArrayListLocal() {
        ArrayList<Local> localArrayList = new ArrayList();
        localDAO.localArrayList = new ArrayList();
        local = new Local("14111-000", 100, 140000, "Cidade pequena", "(16) 2254-2111");
        localDAO.incluirLocal(local);
        localArrayList.add(local);
        local = new Local("14111-001", 100, 140000, "Cidade pequena", "(16) 2254-2111");
        localDAO.incluirLocal(local);
        localArrayList.add(local);
        assertArrayEquals(localDAO.localArrayList.toArray(), localArrayList.toArray());
    }
}
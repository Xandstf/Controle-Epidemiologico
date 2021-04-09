package UseCases.LocalUseCases;

import DAOs.localDAO;
import Entities.Local;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class incluirLocalTest {

    public static Local local;

    @BeforeAll
    public static void criaObjetoLocal(){
        local = new Local();
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir local com todos valores corretos")
    public void casoTesteIncluirLocal(){
        local = new Local("14110-000", 100, 140000, "Cidade pequena", "(16) 3972-2222");
        assertTrue(localDAO.incluirLocal(local));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir local com telefone incorreto")
    public void casoTesteIncluirLocalTelefoneIncorreto(){
        local = new Local("14111-000", 100, 140000, "Cidade pequena", "(16) 39722222");
        assertFalse(localDAO.incluirLocal(local));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir local com CEP incorreto")
    public void casoTesteIncluirLocalCEPincorreto(){
        local = new Local("14110000", 100, 140000, "Cidade pequena", "(16) 3972-2222");
        assertFalse(localDAO.incluirLocal(local));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir Local com CEP igual")
    public void casoTesteIncluirLocalRepetido(){
        local = new Local("14110-001", 100, 140000, "Cidade pequena", "(16) 3972-2222");
        localDAO.incluirLocal(local);
        assertFalse(localDAO.incluirLocal(local));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir local com valores nulos")
    public void casoTesteIncluirLocalNulo(){
        local = new Local("", 0, 0, "", "");
        assertFalse(localDAO.incluirLocal(local));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de incluir local com valores brancos")
    public void casoTesteIncluirPragaValoresBrancos(){
        local = new Local("     ", 0, 0, "   ", "         ");
        assertFalse(localDAO.incluirLocal(local));
    }
}
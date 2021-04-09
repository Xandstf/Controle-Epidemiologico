package UseCases.LocalUseCases;

import DAOs.localDAO;
import DAOs.pragaDAO;
import Entities.Local;
import Entities.Praga;
import UseCases.PragaUseCases.alterarPraga;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class alterarLocalTest {

    public static Local local;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void criaObjetoLocal(){
        local = new Local();
        local = new Local("14110-888", 100, 140000, "Cidade pequena", "(16) 3972-2222");
        assertTrue(localDAO.incluirLocal(local));
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar raio de local existente")
    public void casoTesteAlterarRaioLocalExistente(){
        alterarLocal.alterar("14110-888", "raio", "20");
        assertEquals("** raio atualizado com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar população local existente")
    public void casoTesteAlterarDoencasPragaExistente(){
        alterarLocal.alterar("14110-888", "populacao", "20");
        assertEquals("** Populacao atualizada com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de telefone de local existente")
    public void casoTesteAlterarTempoVidaPragaExistente(){
        alterarLocal.alterar("14110-888", "telefone defesa civil", "20");
        assertEquals("** Telefone defesa civil atualizado com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de caracteristica de local existente")
    public void casoTesteAlterarCombatePragaExistente(){
        alterarLocal.alterar("14110-888", "caracteristicas", "Pequena");
        assertEquals("** Caracteristicas atualizadas com sucesso!", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar local existente com atributo invalido")
    public void casoTesteAlterarPragaExistenteAtributoInvalido(){
        alterarLocal.alterar("14110-888", "caracteristica", "Pequena");
        assertEquals("** Opção invalida! Digite um dos nomes dos atributos.", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Caso de teste do método UseCase de alterar local nao existente")
    public void casoTesteAlterarPragaNaoExistente(){
        alterarLocal.alterar("14110-848", "caracteristicas", "Pequena");
        assertEquals("** Local não encontrado. Liste todos para obter seus respectivos CEPs.", outputStreamCaptor.toString().trim());
    }

}
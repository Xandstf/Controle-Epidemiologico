package Entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalTest {

    public static Local local;

    @BeforeAll
    public static void criaObjetoPraga(){
        local = new Local( );
    }

    @Test
    @DisplayName("Caso de teste do método getCep e setCep")
    public void casoTesteGetSetCEP(){
        local.setCEP_ponto_central("14110-000");
        assertEquals("14110-000", local.getCEP_ponto_central());
    }

    @Test
    @DisplayName("Caso de teste do método getRaio e setRaio")
    public void casoTesteGetSetRaio(){
        local.setRaio(10);
        assertEquals(10, local.getRaio());
    }

    @Test
    @DisplayName("Caso de teste do método get e set de População")
    public void casoTesteGetSetPopulacao(){
        local.setPopulacao(140115);
        assertEquals(140115, local.getPopulacao());
    }

    @Test
    @DisplayName("Caso de teste do método get e set de Características")
    public void casoTesteGetSetCaracteristicas(){
        local.setCaracteristicas("Cidade pequena com muitas áreas abandonadas");
        assertEquals("Cidade pequena com muitas áreas abandonadas", local.getCaracteristicas());
    }

    @Test
    @DisplayName("Caso de teste do método get e set de Telefone Defesa Civil")
    public void casoTesteGetSetModoCombate(){
        local.setTelefone_defesaCivil("(16)9302-5205");
        assertEquals("(16)9302-5205", local.getTelefone_defesaCivil());
    }
}
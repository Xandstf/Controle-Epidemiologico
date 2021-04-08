package Entities;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PragaTest {
    public static Praga praga;

    @BeforeAll
    public static void criaObjetoPraga(){
        praga = new Praga();
    }

    @Test
    @DisplayName("Caso de teste do método getCodigo e setCodigo")
    public void casoTesteGetSetCodigo(){
        praga.setCodigo(1);
        assertEquals(1, praga.getCodigo());
    }

    @Test
    @DisplayName("Caso de teste do método getNome e setNome")
    public void casoTesteGetSetNome(){
        praga.setNome("Aedes aegypti");
        assertEquals("Aedes aegypti", praga.getNome());
    }

    @Test
    @DisplayName("Caso de teste do método get e set de DoencasTransimitidas")
    public void casoTesteGetSetDoencasTransimitidas(){
        praga.setDoencas_Transimitidas("Dengue, zika e chikungunya");
        assertEquals("Dengue, zika e chikungunya", praga.getDoencas_Transimitidas());
    }

    @Test
    @DisplayName("Caso de teste do método get e set de Tempo de Vida")
    public void casoTesteGetSetTempoVida(){
        praga.setTempo_Vida("7 dias");
        assertEquals("7 dias", praga.getTempo_Vida());
    }

    @Test
    @DisplayName("Caso de teste do método get e set de Modos de Combate")
    public void casoTesteGetSetModoCombate(){
        praga.setTempo_Vida("Eliminar agua parada.");
        assertEquals("Eliminar agua parada.", praga.getTempo_Vida());
    }
}
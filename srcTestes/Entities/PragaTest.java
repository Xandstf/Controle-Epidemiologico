package Entities;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PragaTest {
    public static Praga praga;

    @BeforeAll
    public static void criaObjetoPraga() {
        praga = new Praga();
    }

    @Test
    @Order(1)
    @DisplayName("Caso de teste do método getCodigo e setCodigo")
    public void casoTesteGetSetCodigo() {
        praga.setCodigo(1);
        assertEquals(1, praga.getCodigo());
    }

    @Test
    @Order(2)
    @DisplayName("Caso de teste do método getNome e setNome")
    public void casoTesteGetSetNome() {
        praga.setNome("Aedes aegypti");
        assertEquals("Aedes aegypti", praga.getNome());
    }

    @Test
    @Order(3)
    @DisplayName("Caso de teste do método get e set de DoencasTransimitidas")
    public void casoTesteGetSetDoencasTransimitidas() {
        praga.setDoencas_Transimitidas("Dengue, zika e chikungunya");
        assertEquals("Dengue, zika e chikungunya", praga.getDoencas_Transimitidas());
    }

    @Test
    @Order(4)
    @DisplayName("Caso de teste do método get e set de Tempo de Vida")
    public void casoTesteGetSetTempoVida() {
        praga.setTempo_Vida(7);
        assertEquals(7, praga.getTempo_Vida());
    }

    @Test
    @Order(5)
    @DisplayName("Caso de teste do método get e set de Modos de Combate")
    public void casoTesteGetSetModoCombate() {
        praga.setModos_Combate("Eliminar agua parada.");
        assertEquals("Eliminar agua parada.", praga.getModos_Combate());
    }
}
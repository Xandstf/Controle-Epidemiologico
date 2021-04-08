package Entities;

public class Praga {
    private int codigo;
    private String nome;
    private String Doencas_Transimitidas;
    private String Tempo_Vida;
    private String Modos_Combate;

    public Praga(int codigo, String nome, String doencas_Transimitidas, String tempo_Vida, String modos_Combate) {
        this.codigo = codigo;
        this.nome = nome;
        Doencas_Transimitidas = doencas_Transimitidas;
        Tempo_Vida = tempo_Vida;
        Modos_Combate = modos_Combate;
    }

    public Praga() {
        this.codigo = 0;
        this.nome = "";
        Doencas_Transimitidas = "";
        Tempo_Vida = "";
        Modos_Combate = "";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDoencas_Transimitidas() {
        return Doencas_Transimitidas;
    }

    public void setDoencas_Transimitidas(String doencas_Transimitidas) {
        Doencas_Transimitidas = doencas_Transimitidas;
    }

    public String getTempo_Vida() {
        return Tempo_Vida;
    }

    public void setTempo_Vida(String tempo_Vida) {
        Tempo_Vida = tempo_Vida;
    }

    public String getModos_Combate() {
        return Modos_Combate;
    }

    public void setModos_Combate(String modos_Combate) {
        Modos_Combate = modos_Combate;
    }
}

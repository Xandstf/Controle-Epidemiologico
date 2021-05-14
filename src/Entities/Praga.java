package Entities;

public class Praga {
    private int codigo;
    private String nome;
    private String doencas_Transimitidas;
    private int tempo_Vida;
    private String modos_Combate;

    public Praga(int codigo, String nome, String doencas_Transimitidas, int tempo_Vida, String modos_Combate) {
        this.codigo = codigo;
        this.nome = nome;
        this.doencas_Transimitidas = doencas_Transimitidas;
        this.tempo_Vida = tempo_Vida;
        this.modos_Combate = modos_Combate;
    }

    public Praga() {
        this.codigo = -1;
        this.nome = "";
        this.doencas_Transimitidas = "";
        this.tempo_Vida = 0;
        this.modos_Combate = "";
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
        return doencas_Transimitidas;
    }

    public void setDoencas_Transimitidas(String doencas_Transimitidas) {
        this.doencas_Transimitidas = doencas_Transimitidas;
    }

    public int getTempo_Vida() {
        return tempo_Vida;
    }

    public void setTempo_Vida(int tempo_Vida) {
        this.tempo_Vida = tempo_Vida;
    }

    public String getModos_Combate() {
        return modos_Combate;
    }

    public void setModos_Combate(String modos_Combate) {
        this.modos_Combate = modos_Combate;
    }
}

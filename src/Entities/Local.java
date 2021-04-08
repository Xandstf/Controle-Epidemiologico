package Entities;

public class Local {
    private String CEP_ponto_central;
    private int raio;
    private int populacao;
    private String caracteristicas;
    private String telefone_defesaCivil;

    public Local(String CEP_ponto_central, int raio, int populacao, String caracteristicas, String telefone_defesaCivil) {
        this.CEP_ponto_central = CEP_ponto_central;
        this.raio = raio;
        this.populacao = populacao;
        this.caracteristicas = caracteristicas;
        this.telefone_defesaCivil = telefone_defesaCivil;
    }

    public Local() {
        this.CEP_ponto_central = "";
        this.raio = 0;
        this.populacao = 0;
        this.caracteristicas = "";
        this.telefone_defesaCivil = "";
    }

    public String getCEP_ponto_central() {
        return CEP_ponto_central;
    }

    public void setCEP_ponto_central(String CEP_ponto_central) {
        this.CEP_ponto_central = CEP_ponto_central;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getTelefone_defesaCivil() {
        return telefone_defesaCivil;
    }

    public void setTelefone_defesaCivil(String telefone_defesaCivil) {
        this.telefone_defesaCivil = telefone_defesaCivil;
    }
}

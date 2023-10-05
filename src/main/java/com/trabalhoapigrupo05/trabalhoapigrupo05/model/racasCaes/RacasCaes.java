package com.trabalhoapigrupo05.trabalhoapigrupo05.model.racasCaes;

public class RacasCaes {

    private long id;

    private String raca;

    private double tamanho;

    private String paisOrigem;

    private double pesoMedio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public double getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(double pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

}

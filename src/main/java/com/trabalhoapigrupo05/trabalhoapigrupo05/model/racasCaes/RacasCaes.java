package com.trabalhoapigrupo05.trabalhoapigrupo05.model.racasCaes;

public class RacasCaes {

    private long id;

    private String raca;

    private double tamanho;

    private int idade;

    private double peso;

    private String fotoCao;

    private String formularioAdocao;

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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFotoCao() {
        return fotoCao;
    }

    public void setFotoCao(String fotoCao) {
        this.fotoCao = fotoCao;
    }

    public String getFormularioAdocao() {
        return formularioAdocao;
    }

    public void setFormularioAdocao(String formularioAdocao) {
        this.formularioAdocao = formularioAdocao;
    }

}

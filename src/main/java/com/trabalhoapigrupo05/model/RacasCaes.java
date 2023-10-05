package com.trabalhoapigrupo05.model;

public class RacasCaes {

    private long id;
    private String raca;
    private double tamanho;
    private int idade;
    private double peso;
    private String imagem;
    private String formulario;

    //#region Getter's and Setter's
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
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public String getFormulario() {
        return formulario;
    }
    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }
    //#endregion     
}

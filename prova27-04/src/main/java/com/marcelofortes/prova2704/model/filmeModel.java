package com.marcelofortes.prova2704.model;

public class filmeModel {
    private int id;
    private int idSessao;
    private String nome;
    private int faixaEtaria;



    public filmeModel() {
    }
    
    public filmeModel(int idSessao, String nome, int faixaEtaria) {
        this.idSessao = idSessao;
        this.nome = nome;
        this.faixaEtaria = faixaEtaria;
    }
    
    public int getIdSessao() {
        return idSessao;
    }
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getFaixaEtaria() {
        return faixaEtaria;
    }
    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    
}

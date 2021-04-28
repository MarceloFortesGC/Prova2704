package com.marcelofortes.prova2704.model;

public class filmeModel {
    private int id;
    private sessaoModel idSessao;
    private String nome;
    private int faixaEtaria;



    public filmeModel() {
    }

    public filmeModel(sessaoModel idSessao, String nome, int faixaEtaria) {
        this.idSessao = idSessao;
        this.nome = nome;
        this.faixaEtaria = faixaEtaria;
    }

    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public sessaoModel getIdSessao() {
        return idSessao;
    }
    public void setIdSessao(sessaoModel idSessao) {
        this.idSessao = idSessao;
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

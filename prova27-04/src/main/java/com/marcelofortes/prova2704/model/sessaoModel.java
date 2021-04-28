package com.marcelofortes.prova2704.model;

public class sessaoModel {
    private int id;
    private String idSessao;
    private String local;

    
    public sessaoModel() {
    }

    public sessaoModel(String idSessao, String local) {
        this.idSessao = idSessao;
        this.local = local;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getIdSessao() {
        return idSessao;
    }
    public void setIdSessao(String idSessao) {
        this.idSessao = idSessao;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    
}

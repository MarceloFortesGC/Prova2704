package com.marcelofortes.prova2704.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;
import com.marcelofortes.prova2704.dao.sessaoDAO;
import com.marcelofortes.prova2704.model.sessaoModel;

public class sessaoController {
    public Response listarSessoes() {
        try {
          sessaoDAO sessaoDAO = new sessaoDAO();
          List<sessaoModel> src = sessaoDAO.listarSessao();
          return Response.status((Status.OK)).entity(new Gson().toJson(src)).build();
        } 
        catch (Exception e) {
          System.out.println("List sessoes error");
          return Response.status(Status.NOT_FOUND).entity(new Gson().toJson("Erro ao listar sessoes: " + e)).build();
        }
    }

    public Response addSessao(sessaoModel sessao){
        try {
            sessaoDAO sessaoDAO = new sessaoDAO();
            sessaoDAO.addSessao(sessao);
            return Response.status(Status.CREATED).entity(new Gson().toJson("Criado com sucesso")).build();
          } 
          catch (Exception e) {
            System.out.println("add sessao error");
            return Response.status(Status.BAD_REQUEST).entity(new Gson().toJson("Erro ao cadastrar um novo sessao: " + e))
                .build();
          }
    }
    
}

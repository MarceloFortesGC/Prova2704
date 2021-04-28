package com.marcelofortes.prova2704.controller;

import java.util.List;

import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.marcelofortes.prova2704.dao.filmeDAO;
import com.marcelofortes.prova2704.model.filmeModel;

public class MovieController {
    public Response listarFilmes() {
        try {
          filmeDAO filmeDAO = new filmeDAO();
          List<filmeModel> src = filmeDAO.listarFilmes();
          return Response.status((Status.OK)).entity(new Gson().toJson(src)).build();
        } 
        catch (Exception e) {
          System.out.println("List filmes error");
          return Response.status(Status.NOT_FOUND).entity(new Gson().toJson("Erro ao listar Filmes: " + e)).build();
        }
    }

    public Response addFilme(){
        try {
            filmeDAO filmeDAO = new filmeDAO();
            filmeDAO.addfilme(Filme);
            return Response.status(Status.CREATED).entity(new Gson().toJson("Criado com sucesso")).build();
          } catch (Exception e) {
            System.out.println("add filme error");
            return Response.status(Status.BAD_REQUEST).entity(new Gson().toJson("Erro ao Cadastrar nova causa: " + e))
                .build();
          }
    }
    
}

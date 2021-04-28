package com.marcelofortes.prova2704;
  
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.marcelofortes.prova2704.controller.filmeController;
import com.marcelofortes.prova2704.controller.sessaoController;
import com.marcelofortes.prova2704.model.filmeModel;
import com.marcelofortes.prova2704.model.sessaoModel;

@Path("/")
public class Resources {
    filmeController FilmeController = new filmeController();
    sessaoController SessaoController = new sessaoController();

    @GET
    @Path("/filmes")
    @Produces("application/json")
    public Response listarFilmes(){
        return FilmeController.listarFilmes();
    }

    @POST
    @Path("/filmes")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addFilme(filmeModel filme) {
        return FilmeController.addFilme(filme);
    }

    @GET
    @Path("/sessoes")
    @Produces("application/json")
    public Response listarSessoes(){
        return SessaoController.listarSessoes();
    }

    @POST
    @Path("/sessoes")
    @Produces("application/json")
    @Consumes("application/json")
    public Response addSessao(sessaoModel sessao){
        return SessaoController.addSessao(sessao);
    }

}
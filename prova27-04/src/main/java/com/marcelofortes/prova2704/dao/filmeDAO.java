package com.marcelofortes.prova2704.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.marcelofortes.prova2704.model.filmeModel;


public class filmeDAO {

    public Connection connection;
    
    //CRIA TABELA
    public void FilmeTable(){
        String sql = "create table if not exists filmes(id int primary key auto_increment, idSessao varchar(20), nome varchar(20) not null, faixaEtaria int not null, CONSTRAINT fk_idSessao foreign key (idSessao) references sessao(id);";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        } 
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    //CRIA ENTIDADE
    public void addFilme(filmeModel filmes){
        String sql = "insert into filmes(nome, idSessao, faixaEtaria) values (?,?,?);";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, filmes.getNome());
            statement.setInt(2, filmes.getIdSessao());
            statement.setInt(3, filmes.getFaixaEtaria());
            statement.execute();
            statement.close();
        } 
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    //LISTAR ENTIDADES
    public List<filmeModel>listarFilmes(){
        String sql = "select * from filmes;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<filmeModel> filmes = new ArrayList<>();
            filmeModel filme;

            while (resultSet.next()){
                filme = new filmeModel();
                filme.setId(resultSet.getInt("id"));
                filme.setNome(resultSet.getString("nome"));
                filme.setFaixaEtaria(resultSet.getInt("faixaEtaria"));

                filmes.add(filme);
            }

            return filmes;
        } 
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    

}

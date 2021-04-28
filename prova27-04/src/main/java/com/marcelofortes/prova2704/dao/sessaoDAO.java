package com.marcelofortes.prova2704.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.marcelofortes.prova2704.model.sessaoModel;


public class sessaoDAO {
    public Connection connection;
    
    public void SessaoTable(){
        String sql = "create table if not exists sessao(id int primary key auto_increment, idSessao varchar(20), local varchar(20) not null;";
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
    public void addSessao(sessaoModel sessao){
        String sql = "insert into sessao(idSessao, local) values (?,?);";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sessao.getIdSessao());
            statement.setString(2, sessao.getLocal());
            statement.execute();
            statement.close();
        } 
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    //LISTAR ENTIDADES
    public List<sessaoModel>listarSessao(){
        String sql = "select * from sessao;";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            List<sessaoModel> sessoes = new ArrayList<>();
            sessaoModel sessao;

            while (resultSet.next()){
                sessao = new sessaoModel();
                sessao.setIdSessao(resultSet.getString("idSessao"));
                sessao.setLocal(resultSet.getString("local"));

                sessoes.add(sessao);
            }

            return sessoes;
        } 
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public sessaoModel findById(int id) {
        String sql = "select * from sessoes where idSessao = ?;";
        try {
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setInt(1, id);
          ResultSet resultSet = statement.executeQuery();
    
          sessaoModel sessao = new sessaoModel();
          while (resultSet.next()) {
            sessao.setId(resultSet.getInt("id"));
            sessao.setIdSessao(resultSet.getString("idSessao"));
            sessao.setLocal(resultSet.getString("local"));
          }
          return sessao;
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
      }
    
}

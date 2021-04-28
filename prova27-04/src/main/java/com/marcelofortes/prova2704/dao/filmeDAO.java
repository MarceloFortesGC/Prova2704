package com.marcelofortes.prova2704.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.marcelofortes.prova2704.factory.connectionFactory;
import com.marcelofortes.prova2704.model.filmeModel;
import com.marcelofortes.prova2704.model.sessaoModel;


public class filmeDAO {

    public Connection connection;
    
    public filmeDAO() {
        this.connection = new connectionFactory().getConnection();
        FilmeTable();
    }

    //CRIA TABELA
    public void FilmeTable(){
        String sql = "create table if not exists filmes(id int primary key auto_increment, idSessao varchar(20), nome varchar(20) not null, faixaEtaria int not null, CONSTRAINT fk_idfilmeSessao foreign key (idSessao) references sessao(id));";
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
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, filmes.getNome());
            statement.setString(2, filmes.getIdSessao().getIdSessao());
            statement.setInt(3, filmes.getFaixaEtaria());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                filmes.setId(resultSet.getInt(1));
            }
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

                sessaoDAO novaSessaoDAO = new sessaoDAO();
                sessaoModel novaSessaoModel = novaSessaoDAO.findById(resultSet.getString("idSessao"));

                filme.setIdSessao(novaSessaoModel);
                filmes.add(filme);
            }

            return filmes;
        } 
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    

}

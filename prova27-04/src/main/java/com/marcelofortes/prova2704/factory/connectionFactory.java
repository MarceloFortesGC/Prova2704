package com.marcelofortes.prova2704.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/cinema", "root","");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}

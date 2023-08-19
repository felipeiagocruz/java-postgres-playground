package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class AppBd {
    public static void main(String[] args) {


        try {
            Class.forName("org.postgresql.Driver");

        } 
        catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.err.println("Não foi possível carregar a bibblioteca para acessa ao banco de dados." + e.getMessage());
        } 


        Statement statement = null;

        try (Connection conn = DriverManager.getConnection("jdbc:postgre://localhost/postgres", "gitpod", "");) {
                
            System.out.println("Conexão com o banco realizada com sucesso.");
    
            statement = conn.createStatement();
    
            var result = statement.executeQuery("SELECT * from estado");
    
            while(result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s \n", result.getInt("id"),result.getString("nome"), result.getString("UF"));  
            } 
        } 
        catch (SQLException e) {
            if(statement == null)
                System.err.println("Não foi possível conectar ao banco de dados:"+ e.getMessage());
            else   
                System.out.println("Não foi possível realizar a consulta ao banco de dados." + e.getMessage());
        }
        
    }
    
}

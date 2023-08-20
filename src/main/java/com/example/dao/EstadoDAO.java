package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn){
        this.conn = conn;
    }

    public void localizar(String uf) {
        try{
              // String query = "SELECT * from estado where uf ='"+uf+"'"; //suscetível a SQL Injection
            String SQLquery = "SELECT * from estado where uf = ?";
            var statement = conn.prepareStatement(SQLquery);
            statement.setString(1, uf);
            var result = statement.executeQuery();
            if(result.next()){
                System.out.printf("Id: %d | Nome: %s | UF: %s \n",result.getInt("id"),result.getString("nome"),result.getString("uf"));
            }
        }   
        catch(SQLException e){
            System.err.printf("Não foi possível localizar o estado %s |" + e.getMessage(),uf);
        }
    }

    public void listar() {
        try{
            var statement = conn.createStatement();
    
            var result = statement.executeQuery("SELECT * from estado");
    
            while(result.next()) {
                System.out.printf("Id: %d Nome: %s UF: %s \n", result.getInt("id"),result.getString("nome"), result.getString("UF"));  
            } 
        } 
        catch (SQLException e) {
                System.err.println("Não foi possível conectar ao banco de dados:"+ e.getMessage());
        }
    }




}

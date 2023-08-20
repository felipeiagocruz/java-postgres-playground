package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class AppBd {
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    public static void main(String[] args) {
      new AppBd();
      
    }

    public AppBd(){
        carregarDriverJDBC(); 
        try (Connection conn = getConnection()) {
        // listarEstados(conn);
        //localizarEstado(conn,"TO");
        listarDadosTabela(conn,"cidade");
        }
        catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados:"+ e.getMessage());        }
    }


    private void listarDadosTabela(Connection conn, String tabela) {
        var sql = "SELECT * from " + tabela;
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);
            var metadata = result.getMetaData(); 
            int cols = metadata.getColumnCount();
            for(int i=1; i<= cols;i++){
                System.out.printf("%-25s |",metadata.getColumnName(i));
           }
           System.out.println();
            while(result.next()){
               
               for(int i=1; i<= cols;i++){
                    System.out.printf("%-25s |",result.getString(i));
               }
               System.out.println();
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.err.printf("Erro na execução da consulta" + e.getMessage());
        }
       

    }

    private void localizarEstado(Connection conn, String uf) {
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

    private void listarEstados(Connection conn) {
        try{
                
            System.out.println("Conexão com o banco realizada com sucesso.");
    
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

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");

        } 
        catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.err.println("Não foi possível carregar a bibblioteca para acessa ao banco de dados." + e.getMessage());
        }
    }
    
}

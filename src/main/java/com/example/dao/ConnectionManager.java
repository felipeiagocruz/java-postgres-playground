package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");

        } 
        catch (ClassNotFoundException e) {
            // TODO: handle exception
            System.err.println("Não foi possível carregar a bibblioteca para acessa ao banco de dados." + e.getMessage());
        }
    }
}

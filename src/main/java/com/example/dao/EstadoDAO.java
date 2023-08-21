package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

public class EstadoDAO extends DAO {
    public EstadoDAO(Connection conn){
        super(conn);
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

    public List<Estado> listar() throws SQLException {

        List<Estado> lista = new LinkedList<Estado>();
        

            var  statement = conn.createStatement();
            var result = statement.executeQuery("SELECT * from estado");
    
            while(result.next()) {
                var estado = new Estado();
                estado.setId(result.getLong("id"));
                estado.setNome(result.getString("nome")); 
                estado.setUf(result.getString("UF"));  
                lista.add(estado);
            } 
            
    
        return lista;
    }

       
}

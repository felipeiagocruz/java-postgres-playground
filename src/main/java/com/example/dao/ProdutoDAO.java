package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO {
    private Connection conn;

    public ProdutoDAO(Connection conn){
        this.conn = conn;
    }

    public void excluir(Long id) {
        var sql = "DELETE FROM produto WHERE id = ?;";
        try (var statement = conn.prepareStatement(sql);) {
            statement.setLong(1,id);
            if(statement.executeUpdate()>0){
                System.out.println("Produto deletado com sucesso.");
            }else
                System.out.println("Nenhuma linha foi deletada.");
            
        } catch (Exception e) {
            System.err.println("Falha na deleção do item." + e.getMessage());
        }





    }

public void alterar(Produto produto) {
        var sql = "UPDATE produto SET nome = ?,marca_id = ?,valor = ? WHERE id = ?;";
        try(var statement = conn.prepareStatement(sql);){
        statement.setString(1,produto.getNome());
        statement.setLong(2, produto.getMarca().getId());
        statement.setDouble(3, produto.getValor());
        statement.setDouble(4, produto.getId());
        if(statement.executeUpdate()>0){
            System.out.println("Produto alterado com sucesso.");
        }else
            System.out.println("Nenhuma linha foi alterada.");
        }
        catch(SQLException e){
            System.err.println("Não foi possível inserir o produto no banco de dados" + e.getMessage());
        }

    }

 public void inserir(Produto produto) {
        var sql = "INSERT INTO produto (nome,marca_id,valor) VALUES(?,?,?);";
        try(var statement = conn.prepareStatement(sql);){
        statement.setString(1,produto.getNome());
        statement.setLong(2, produto.getMarca().getId());
        statement.setDouble(3, produto.getValor());
        statement.executeUpdate();
        System.out.println("Produto criado.");
        }
        catch(SQLException e){
            System.err.println("Não foi possível inserir o produto no banco de dados" + e.getMessage());
        }

    }


}

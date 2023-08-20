package com.example;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;


public class AppBd {
    public static void main(String[] args) {
      new AppBd();
      
    }

    public AppBd(){
        ConnectionManager.carregarDriverJDBC(); 
        try (Connection conn = ConnectionManager.getConnection()) {
        var estadoDAO = new EstadoDAO(conn);
        var produtoDAO = new ProdutoDAO(conn);
        var DAO = new DAO(conn);
        
        estadoDAO.listar();
        estadoDAO.localizar("TO");
        
        var marca = new Marca();
        marca.setId(1L);
        var produto = new Produto();
        long id = 203;
        produto.setMarca(marca);
        produto.setNome("Produto deletável");
        produto.setValor(100D);
        produto.setId(id);
        //inserirProduto(conn,produto);
        //excluirProduto(conn,id);
        produtoDAO.alterar(produto);
        DAO.listarTabela("produto");
     
        }
        catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados:"+ e.getMessage());        }
    }





   

 
    
}

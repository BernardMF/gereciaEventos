/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Conexao.ConnectionFactory;
import Model.bean.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus Henrique
 */
public class ProdutosDAO {

    
    
    Connection con;
    ObservableList<String> posVetor = FXCollections.observableArrayList();
    ObservableList<String> posVetor1 = FXCollections.observableArrayList();

    public ObservableList<String> getPosVetor1() {
        return posVetor1;
    }
    
     public ProdutosDAO() {
        con = ConnectionFactory.getConnection();
    }
     public ObservableList<String> getPosVetor() {
        return posVetor;
    }
    
     
      public void create(Produtos p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cadastroproduto (nome,categoria,preco,descricao)VALUES(?,?,?,?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCategoria());
            stmt.setString(3, p.getPreco());
            stmt.setString(4, p.getDescricao()); 
            

            stmt.executeUpdate();
            posVetor.add(p.getNome());

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.fecharConecao(con, stmt);
        }

    }
      
      
      public void read(){
          PreparedStatement stmt = null;
        ResultSet rs = null;

        //ArrayList<Produtos> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM cadastroproduto");
            rs = stmt.executeQuery();
            
            
         
            while (rs.next()) {

                Produtos produto = new Produtos();                         

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("Categoria"));
                produto.setPreco(rs.getString("preco"));
                produto.setDescricao(rs.getString("descricao"));            
                
                
                 posVetor.add(produto.getNome());
                 posVetor1.add("R$ "+produto.getPreco());
                 
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ProdutosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fechaConecao(con, stmt, rs);
        }

          
      }
}

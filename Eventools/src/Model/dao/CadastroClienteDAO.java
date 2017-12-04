/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Conexao.ConnectionFactory;
import Model.bean.CadastroCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author matheus Henrique
 */
public class CadastroClienteDAO {
    
    Connection con;
    
    public CadastroClienteDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public void create(CadastroCliente c){
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cadastrocliente (nome,sexo,cpf,telefone,email,endereco,senha,confsenha)VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getSexo());
            stmt.setString(3, c.getCPF());
            stmt.setString(4, c.getTelefone());
            stmt.setString(5, c.getEmail());
            stmt.setString(6, c.getEndereco());
            stmt.setString(7, c.getSenha());
            stmt.setString(8, c.getConfirmarSenha());
            
            stmt.executeUpdate();
            
            
             JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao Salvar!"+ex);
        }finally{
            ConnectionFactory.fecharConecao(con, stmt);
        }
    }
    
    public List<CadastroCliente> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<CadastroCliente> Clientes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {

                CadastroCliente cliente = new CadastroCliente();

                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setCPF(rs.getString("cpf"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setConfirmarSenha(rs.getString("confsenha"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fechaConecao(con, stmt, rs);
        }

        return Clientes;

    }
    
    //ALterado
    
    public void verificaLogin(String a, String b){
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean valor = false;
        try {
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
               if(( rs.getString("email").equals(a)) && rs.getString("senha").equals(b)){
                   valor = true;
               }//fim if                
            }//fim while

        } catch (SQLException ex) {
            Logger.getLogger(CadastroClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.fechaConecao(con, stmt, rs);
        }
        
    }
            
    
}

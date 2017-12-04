/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventools;

import Model.bean.CadastroCliente;
import Model.dao.CadastroClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Bernardo
 */
public class TelaCadastroController implements Initializable {

    ObservableList<String> sexoList = FXCollections.observableArrayList("M", "F");
    
    @FXML
    private ComboBox SexoBox;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoCpf;
    @FXML
    private TextField campoTelefone;
    @FXML
    private TextField campoEmail;
    @FXML
    private TextArea campoEndereco;
    @FXML
    private PasswordField campoSenha;
    @FXML
    private PasswordField campoConfSenha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SexoBox.setValue("Escolha o seu sexo");
        SexoBox.setItems(sexoList);
    }    
    
    @FXML
    public void cancelarCadastro(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("telaLogin.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    public void finalizarCadastro(ActionEvent event) throws IOException{
       if (validarNome(campoNome.getText()) && validarCpf(campoCpf.getText()) && validarTelefone(campoTelefone.getText())
               && validarEmail(campoEmail.getText()) && validarSenha(campoSenha.getText(), campoConfSenha.getText())){
           //PARTE DE MATHEUS HENRIQUE(ALTERADA)*****************************************************
           // SALVANDO AS ENTRADAS NO BANCO DE DADOS*************************************************
           
           
           CadastroCliente c = new CadastroCliente();
           CadastroClienteDAO dao = new CadastroClienteDAO();
           c.setNome(campoNome.getText());
           c.setSexo(SexoBox.getValue().toString());
           c.setCPF(campoCpf.getText());
           c.setTelefone(campoTelefone.getText());
           c.setEmail(campoEmail.getText());
           c.setEndereco(campoEndereco.getText());
           c.setSenha(campoSenha.getText());
           c.setConfirmarSenha(campoConfSenha.getText());
           
           dao.create(c);
           
           
           
           //FINAL DA PARTE ALTERADA********************************************************************
           JOptionPane.showMessageDialog(null, "Conta Criada com Sucesso");
           Parent tableViewParent = FXMLLoader.load(getClass().getResource("telaLogin.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();

       }
    }
    
    public boolean validarCpf(String cpf){
        if(cpf.length()==11){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "verifique o campo CPF");
            return false;
        }
    }
    
    public boolean validarSenha(String s1, String s2){
        if ((s1.length()>=8)){
        }else{
        JOptionPane.showMessageDialog(null, "Senha menor que 8 caracteres");
        return false;
        }
        if(s1.equals(s2)){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Senhas diferentes");
            return false;
        }
    }
    public boolean validarTelefone(String tel){
        if(tel.length()>=8){
           return true;
        }else{
            JOptionPane.showMessageDialog(null, "Verifique o campo Telefone");
            return false;
        }
    }
    
    public boolean validarEmail(String email){
        if (email.length()>0){
            return true;
        } else{
            JOptionPane.showMessageDialog(null, "Verifique o campo email");
            return false;
        }
    }
    
    public boolean validarNome(String nome){
        if(nome.length()>5){
            return true;
        } else{
            JOptionPane.showMessageDialog(null, "Verifique o campo nome");
            return false;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventools;

import Model.bean.Produtos;
import Model.dao.ProdutosDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import eventools.custom.MaskTextField;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Bernardo
 */
public class TelaNovoProdutoController implements Initializable {
    ObservableList<String> categoriasList = FXCollections.observableArrayList("Comida", "Som", "Iluminação", "Foto/Filmagem", "Decoração");
    
    @FXML
    private TextField campoNome;
    @FXML
    private ComboBox boxCategoria;
    @FXML
    private MaskTextField campoPreco;
    @FXML
    private TextField campoDescricao;
    @FXML
    private TextField campoImagem;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        boxCategoria.setValue("Escolha");
        boxCategoria.setItems(categoriasList);
        
        campoPreco.setMask("N!,NN");
        String categoria1 = boxCategoria.getValue().toString();
    }    
    
    @FXML
    public void acaoCancelar(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("telaEmpresa2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
    @FXML
    public void acaoCompletarCadastro (ActionEvent event) throws IOException{
        if(verificarNome(campoNome.getText()) && verificarDescricao(campoDescricao.getText()) && verificarPreco(campoPreco.getText())){
           //PARTE DE MATHEUS HENRIQUE(ALTERADA)*****************************************************
           // SALVANDO AS ENTRADAS NO BANCO DE DADOS*************************************************
           
           Produtos p = new Produtos();
           ProdutosDAO dao = new ProdutosDAO();
           p.setNome(campoNome.getText());
           p.setCategoria(boxCategoria.getValue().toString());
           p.setPreco(campoPreco.getText());
           p.setDescricao(campoDescricao.getText());
           
           dao.create(p);
           
           //FINAL DA PARTE ALTERADA********************************************************************
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("telaEmpresa2.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
    }
    
   
    public boolean verificarNome(String nome){
        if (nome.length()>=1){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Verificar campo Nome");
            return false;
        }
    }
    
    public boolean verificarPreco(String preco){
        if((preco.length()>=3)&& (preco.contains("'"))){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Verificar Campo Preço");
            return false;
        }
    }
    
    public boolean verificarDescricao(String descricao){
        if(descricao.length()>=5){
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Descrição insuficiente");
            return false;
        }
    }
    
    @FXML
    public void funcaoNaoImplementada(javafx.event.ActionEvent event){
        JOptionPane.showMessageDialog(null, "Funcao nao implementada");
    }
    
}

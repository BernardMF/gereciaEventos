/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventools;

import Model.bean.Produtos;
import Model.dao.ProdutosDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author matheus Henrique
 */
public class TelaEmpresa2Controller implements Initializable {
    
    @FXML
    private ListView listaProd;
    @FXML
    private ListView listaPreco;
    @FXML
    private Button atualiza;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void atualizaLista(javafx.event.ActionEvent event){
        
        Produtos p = new Produtos();
        ProdutosDAO prod = new ProdutosDAO();
        prod.read();
        listaProd.setItems(prod.getPosVetor());
        listaPreco.setItems(prod.getPosVetor1());     
        
    }
    
    @FXML
    public void addProduto(javafx.event.ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("telaNovoProduto.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    
     @FXML
    public void funcaoNaoImplementada(javafx.event.ActionEvent event){
        JOptionPane.showMessageDialog(null, "Funcao nao implementada");
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventools;


import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Bernardo
 */
public class TelaLoginController implements Initializable {
    @FXML
    private TextField campoEmail;
    @FXML
    private PasswordField campoSenha;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void acaoLogin(ActionEvent event) throws IOException{
        if (campoEmail.getText().equals("admin") && campoSenha.getText().equals("admin")){
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("telaEmpresa.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        } else{
            JOptionPane.showMessageDialog(null, "Email ou Senha incorreto(s)");
        }
    }
    @FXML
    public void acaoCadastrese(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("telaCadastro.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        }
        
}

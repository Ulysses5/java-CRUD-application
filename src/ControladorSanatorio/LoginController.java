/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorSanatorio;

import java.net.URL;
import java.io.IOException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ulises
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private Button btnExit;
    @FXML
    private TextField campoUser;
    @FXML
    private PasswordField campoPass;
    @FXML
    private Button btnRegister;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void loginClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/MenuVista.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow();
        window.setScene(new Scene(root));
    }




    @FXML
    private void exitClicked(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void registerClicked(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/RegistroVista.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
}
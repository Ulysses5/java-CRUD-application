/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorSanatorio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ulises
 */
public class RegistroControlador implements Initializable {

    @FXML
    private TextField campoRegUser;
    @FXML
    private PasswordField campoRegPass;
    @FXML
    private Button btnRegisterUser;
    @FXML
    private Button btnExit;
    @FXML
    private TextField campoRegMail;
    @FXML
    private PasswordField campoRegPass2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registerUserClicked(ActionEvent event) {
        Alert registro = new Alert(Alert.AlertType.INFORMATION);
        registro.setTitle("Usuario Creado");
        Stage stage = (Stage) registro.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
        registro.setHeaderText(null);
        registro.setContentText("El usuario ingresado ha sido creado.");
        registro.showAndWait();
    }

    @FXML
    private void exitClicked(ActionEvent event) {
        System.exit(0);
    }
    
}

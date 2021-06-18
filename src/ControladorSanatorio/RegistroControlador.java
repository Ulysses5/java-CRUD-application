/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorSanatorio;

import ModeloSanatorio.ModeloUsuario;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private void registerUserClicked(ActionEvent event) throws SQLException, IOException {
        if (campoRegPass.getText().equals(campoRegPass2.getText()) && !("".equals(campoRegMail.getText())) && !("".equals(campoRegUser.getText()))) {
            ModeloUsuario user = new ModeloUsuario(campoRegUser.getText(), campoRegMail.getText(), campoRegPass.getText());
            int loginCode = user.registerUser();
            if (0 == loginCode) {
                Alert registro = new Alert(Alert.AlertType.CONFIRMATION);
                registro.setTitle("Usuario Creado");
                Stage stage = (Stage) registro.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
                registro.setHeaderText(null);
                registro.setContentText("El usuario ingresado ha sido creado.");
                registro.showAndWait();
                Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/LoginVista.fxml"));
                Stage window = (Stage) btnRegisterUser.getScene().getWindow();
                window.centerOnScreen();
                window.setScene(new Scene(root));
                
            }}
            else{
                Alert registro = new Alert(Alert.AlertType.ERROR);
                registro.setTitle("Usuario Creado");
                Stage stage = (Stage) registro.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
                registro.setHeaderText(null);
                registro.setContentText("Error al crear usuario\nCompruebe los datos.");
                registro.showAndWait();                
            }
        }

    @FXML
    private void exitClicked(ActionEvent event) {
        System.exit(0);
    }
    
}

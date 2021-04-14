/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorSanatorio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ulises
 */
public class MenuController implements Initializable {

    @FXML
    private Button btnLogout;
    @FXML
    private ImageView btnBusqueda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/LoginVista.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private void btnBuscarPaciente(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/LoginVista.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
}

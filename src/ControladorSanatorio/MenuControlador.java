package ControladorSanatorio;

import ModeloSanatorio.ModeloUsuario;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ulises
 */
public class MenuControlador implements Initializable {

    @FXML
    private Hyperlink btnLogout;
    @FXML
    private Button btnBusqueda;
    @FXML
    private Label usuarioText;
    @FXML
    private Button btnAñadir;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

    }    

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/LoginVista.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow();
        window.centerOnScreen();
        window.setScene(new Scene(root));
    }

    @FXML
    private void btnBuscarPaciente(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/BusquedaVista.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow();
        window.centerOnScreen();
        window.setScene(new Scene(root));
    }


    @FXML
    private void btnAñadirPaciente(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/AnadirVista.fxml"));
        Stage window = (Stage) btnLogout.getScene().getWindow();
        window.centerOnScreen();
        window.setScene(new Scene(root));
    }
}

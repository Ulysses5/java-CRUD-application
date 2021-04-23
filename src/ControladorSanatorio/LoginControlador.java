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


public class LoginControlador implements Initializable {
    public String USER;
    public String PASS;
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
    public void loginClicked(ActionEvent event) throws IOException {
        USER = this.campoUser.getText();
        PASS = this.campoPass.getText();
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/MenuVista.fxml"));
        Stage window = (Stage) btnLogin.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public String getUSER() {
        return this.USER;
    }

    public String getPASS() {
        return this.PASS;
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

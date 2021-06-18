package ControladorSanatorio;

import ModeloSanatorio.ModeloUsuario;
import java.net.URL;
import java.io.IOException;
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


public class LoginControlador implements Initializable {
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    public void loginClicked(ActionEvent event) throws IOException, SQLException {
        ModeloUsuario user = new ModeloUsuario(campoUser.getText(), campoPass.getText());
        int loginCode = user.loginUser();
        if (0 == loginCode){
            Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/MenuVista.fxml"));
            Stage window = (Stage) btnLogin.getScene().getWindow();
            window.setScene(new Scene(root));
        }
        else{
            Alert loginFailed = new Alert(Alert.AlertType.ERROR);
            loginFailed.setTitle("Credenciales incorrectas");
            Stage stage = (Stage) loginFailed.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
            loginFailed.setHeaderText(null);
            loginFailed.setContentText("El usuario o contraseña son incorrectos.");
            loginFailed.showAndWait();
        }
        
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

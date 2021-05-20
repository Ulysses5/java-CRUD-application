package ControladorSanatorio;

import Conector.ConectorMariaDB;
import java.net.URL;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public void loginClicked(ActionEvent event) throws IOException, SQLException {
        ConectorMariaDB con = new ConectorMariaDB();
        ArrayList<String> valores = new ArrayList<String>();
        valores.add(campoUser.getText());
        valores.add(campoPass.getText());
        con.ejecutarConsultaPreparada("SELECT * FROM `loginInfo` WHERE `username` = ? AND `password` = SHA2(?,256)", valores);
        ResultSet rs = con.getResultSet();
        
        if (rs.next()){
            Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/MenuVista.fxml"));
            Stage window = (Stage) btnLogin.getScene().getWindow();
            window.setScene(new Scene(root));
        }
        else{
            Alert login = new Alert(Alert.AlertType.ERROR);
            login.setTitle("Credenciales incorrectas");
            Stage stage = (Stage) login.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
            login.setHeaderText(null);
            login.setContentText("El usuario o contraseña son incorrectos.");
            login.showAndWait();
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

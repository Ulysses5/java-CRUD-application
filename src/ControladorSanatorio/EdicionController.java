
package ControladorSanatorio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EdicionController implements Initializable {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtDNI;
    @FXML
    private TextField txtTelefono;
    @FXML
    private ComboBox<String> cboxSexo;
    @FXML
    private TextField txtDireccion;
    @FXML
    private ComboBox<String> cboxOS;
    @FXML
    private TextField txtIDOS;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnAceptar;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxSexo.getItems().addAll("Femenino","Masculino");
        cboxOS.getItems().addAll("OSDE","Swiss Medical");
        
    }    

    @FXML
    private void clickCancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void clickAceptar(ActionEvent event) {
        
    }
    
}
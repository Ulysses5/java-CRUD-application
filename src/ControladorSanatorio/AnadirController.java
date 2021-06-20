/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorSanatorio;

import ModeloSanatorio.ModeloPersona;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ulises
 */
public class AnadirController implements Initializable {

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
    @FXML
    private DatePicker fechaNac;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxSexo.getItems().addAll("Femenino","Masculino");
        cboxOS.getItems().addAll("OSDE","Swiss Medical");    }    

    @FXML
    private void clickCancelar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/MenuVista.fxml"));
        Stage window = (Stage) btnCancelar.getScene().getWindow();
        window.centerOnScreen();
        window.setScene(new Scene(root));

    }
    @FXML
    private void clickAceptar(ActionEvent event) {
        if (txtNombre.getText().trim().equals("")||txtApellido.getText().trim().equals("")
                ||(txtDNI.getText().trim().equals("") || txtDireccion.getText().trim().equals(""))
                ||(txtIDOS.getText().trim().equals("") || txtTelefono.getText().trim().equals(""))
                ||(cboxOS.getValue().trim().equals("")|| cboxSexo.getValue().trim().equals("")
                ||(fechaNac.getValue().toString().equals(""))))
        {
            Alert camposVacios = new Alert(Alert.AlertType.ERROR);
            camposVacios.setTitle("Busqueda erronea");
            Stage stage = (Stage) camposVacios.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
            camposVacios.setHeaderText(null);
            camposVacios.setContentText("Error en la creación (Verifique los datos ingresados)");
            camposVacios.showAndWait();                
        }
            ModeloPersona p = new ModeloPersona(txtNombre.getText(), txtApellido.getText(), txtDNI.getText(), txtTelefono.getText(), txtDireccion.getText(), cboxOS.getValue(), txtIDOS.getText(), cboxSexo.getValue(), fechaNac.getValue().toString());
            int code = p.addPersona();
            if (code == 0) {
                System.out.println("Hola");
        }
            
            
    }
    
}

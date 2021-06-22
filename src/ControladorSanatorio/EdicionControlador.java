
package ControladorSanatorio;

import ModeloSanatorio.ModeloObraSocial;
import ModeloSanatorio.ModeloPersona;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class EdicionControlador implements Initializable {

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cboxSexo.getItems().addAll("Femenino","Masculino");
        ModeloObraSocial obras = new ModeloObraSocial();
        cboxOS.getItems().addAll(obras.getObraSociales());
        

    }

    @FXML
    private void clickCancelar(ActionEvent event) {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
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
        else{
            ModeloPersona p = new ModeloPersona(txtNombre.getText(), txtApellido.getText(), txtDNI.getText(), txtTelefono.getText(), txtDireccion.getText(), cboxOS.getValue(), txtIDOS.getText(), cboxSexo.getValue(), fechaNac.getValue().toString());
            int code = p.updatePaciente();
            if (code == 1) {
                Alert pacienteCreado = new Alert(Alert.AlertType.INFORMATION);
                pacienteCreado.setTitle("Paciente actualizado");
                Stage stage = (Stage) pacienteCreado.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
                pacienteCreado.setHeaderText(null);
                pacienteCreado.setContentText("Paciente actualzado de forma exitosa");
                pacienteCreado.showAndWait(); 
                Stage window = (Stage) btnAceptar.getScene().getWindow();
                window.close();
        }
        }
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre.setText(txtNombre);
    }

    public void setTxtApellido(String txtApellido) {
        this.txtApellido.setText(txtApellido);
    }

    public void setTxtDNI(String txtDNI) {
        this.txtDNI.setText(txtDNI);
    }

    public void setTxtTelefono(String txtTelefono) {
        this.txtTelefono.setText(txtTelefono);
    }

    public void setCboxSexo(String cboxSexo) {
        this.cboxSexo.setValue(cboxSexo);
    }

    public void setTxtDireccion(String txtDireccion) {
        this.txtDireccion.setText(txtDireccion);
    }

    public void setCboxOS(String cboxOS) {
        this.cboxOS.setValue(cboxOS);
    }

    public void setTxtIDOS(String IDOS) {
        this.txtIDOS.setText(IDOS);
    }

    public void setFechaNac(String fechaNac) {
        LocalDate date;
        this.fechaNac.setValue(date = LocalDate.parse(fechaNac));
    }
    
}

package ControladorSanatorio;

import ModeloSanatorio.Persona;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ulises
 */
public class BusquedaControlador implements Initializable {

    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoApellido;
    @FXML
    private TextField campoDNI;
    @FXML
    private Button btnOk;
    @FXML
    private TextField campoDireccion;
    @FXML
    private TextField campoObraSocial;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoIDObra;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchClicked(ActionEvent event){
        String dni = (this.campoDNI.getText());
        Persona p = null;
        if (this.campoDNI.getText().isEmpty()) {
            Alert dniVacio = new Alert(Alert.AlertType.INFORMATION);
            dniVacio.setTitle("DNI Vacio");
            Stage stage = (Stage) dniVacio.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
            dniVacio.setHeaderText(null);
            dniVacio.setContentText("El campo DNI está vacio");
            dniVacio.showAndWait();
        }
        else{

            try {
                p = new Persona(dni);
            } catch (SQLException ex ) {
                Alert dniVacio = new Alert(Alert.AlertType.INFORMATION);
                dniVacio.setTitle("Error en la busqueda");
                Stage stage = (Stage) dniVacio.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
                dniVacio.setHeaderText(null);
                dniVacio.setContentText("Error en la busqueda" + ex);
                dniVacio.showAndWait();
            }
            catch (Exception ex){
                Alert dniVacio = new Alert(Alert.AlertType.INFORMATION);
                dniVacio.setTitle("DNI Vacio o erroneo");
                Stage stage = (Stage) dniVacio.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
                dniVacio.setHeaderText(null);
                dniVacio.setContentText("Error en la busqueda" + ex);
                dniVacio.showAndWait();                
            }
            campoNombre.setText(p.getNombre());
            campoApellido.setText(p.getApellido());
            campoDireccion.setText(p.getDireccion());
            campoObraSocial.setText(p.getObraSoc());
            campoTelefono.setText(p.getTelefono());
            campoIDObra.setText(p.getIdObraSoc());
        }
    }
    
}

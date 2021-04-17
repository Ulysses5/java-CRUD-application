package ControladorSanatorio;

import ModeloSanatorio.Persona;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    private void searchClicked(ActionEvent event) throws SQLException {
            String dni = (this.campoDNI.getText());
            Persona p = new Persona(dni);
            campoNombre.setText(p.getNombre());
            campoApellido.setText(p.getApellido());
            campoDireccion.setText(p.getDireccion());
            campoObraSocial.setText(p.getObraSoc());
            campoTelefono.setText(p.getTelefono());
            campoIDObra.setText(p.getIdObraSoc());
    }
    
}

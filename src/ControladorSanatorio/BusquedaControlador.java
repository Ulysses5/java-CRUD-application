package ControladorSanatorio;

import java.net.URL;
import java.util.ResourceBundle;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

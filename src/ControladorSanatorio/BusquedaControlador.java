package ControladorSanatorio;

import ModeloSanatorio.ModeloPersona;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ulises
 */
public class BusquedaControlador implements Initializable {

    @FXML
    private TextField campoDNI;
    @FXML
    private Button btnOk;
    @FXML
    private TableView<ModeloPersona> tablaPacientes;
    @FXML
    private TableColumn<ModeloPersona,String> colNombre;
    @FXML
    private TableColumn<ModeloPersona,String> colApellido;
    @FXML
    private TableColumn<ModeloPersona,String> colDNI;
    @FXML
    private TableColumn<ModeloPersona,String> colSexo;
    @FXML
    private TableColumn<ModeloPersona,String> colDireccion;
    @FXML
    private TableColumn<ModeloPersona,String> colOS;
    @FXML
    private TableColumn<ModeloPersona,String> colIDOS;
    @FXML
    private TableColumn<ModeloPersona,String> colTelefono;
    @FXML
    private Button btnVolver;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnBorrar;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        this.colDNI.setCellValueFactory(new PropertyValueFactory("dni"));
        this.colDireccion.setCellValueFactory(new PropertyValueFactory("direccion"));
        this.colOS.setCellValueFactory(new PropertyValueFactory("obraSoc"));
        this.colIDOS.setCellValueFactory(new PropertyValueFactory("idObraSoc"));
        this.colSexo.setCellValueFactory(new PropertyValueFactory("Sexo"));
        this.colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
    }    

    @FXML
    private void searchClicked(ActionEvent event){
        
        String busqueda = (this.campoDNI.getText());
        ModeloPersona p = null;
            try {
                p = new ModeloPersona(busqueda);  
            }
            catch (Exception ex){
                Alert dniVacio = new Alert(Alert.AlertType.ERROR);
                dniVacio.setTitle("Busqueda erronea");
                Stage stage = (Stage) dniVacio.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
                dniVacio.setHeaderText(null);
                dniVacio.setContentText("Error en la busqueda" + ex);
                dniVacio.showAndWait();                
            }
            
            tablaPacientes.setItems(p.getPersonas());
            
            
            
            
        }

    @FXML
    private void editClicked(ActionEvent event) {
        try{
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/VistaSanatorio/EdicionVista.fxml"));
            Parent root = loader.load();
                
            
            EdicionControlador controlador = loader.getController();
            if (!tablaPacientes.getSelectionModel().getSelectedItem().getDni().equals("")) {
                controlador.setTxtDNI(tablaPacientes.getSelectionModel().getSelectedItem().getDni());
                ModeloPersona campos = new ModeloPersona(tablaPacientes.getSelectionModel().getSelectedItem().getDni());
                ArrayList valoresCampos = campos.getDatosPaciente(tablaPacientes.getSelectionModel().getSelectedItem().getDni());
                System.out.println(valoresCampos);
                controlador.setTxtNombre((String) valoresCampos.get(0));
                controlador.setTxtApellido((String) valoresCampos.get(1));
                controlador.setTxtDireccion((String) valoresCampos.get(2));
                controlador.setTxtTelefono((String) valoresCampos.get(3));
                controlador.setTxtIDOS((String) valoresCampos.get(4));
                controlador.setCboxOS((String) valoresCampos.get(5));
                controlador.setCboxSexo((String) valoresCampos.get(6));
                controlador.setFechaNac((String) valoresCampos.get(7));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
                String busqueda = (this.campoDNI.getText());
                ModeloPersona p = null;
                p = new ModeloPersona(busqueda);
                tablaPacientes.setItems(p.getPersonas());
            }
            else{
                System.out.println("Hola");
            }
        }
        catch(IOException ex){
            System.out.println(ex);
        }
    }

    @FXML
    private void backClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/VistaSanatorio/MenuVista.fxml"));
        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.centerOnScreen();
        window.setScene(new Scene(root));
    }

    @FXML
    private void deleteClicked(ActionEvent event) {
        ModeloPersona obj = tablaPacientes.getSelectionModel().getSelectedItem();
        if (!obj.getDni().equals("")) {
            ModeloPersona d = new ModeloPersona(obj.getDni());
            d.setDni(obj.getDni());
            d.deletePaciente();
            Alert pacienteBorrado = new Alert(Alert.AlertType.INFORMATION);
            pacienteBorrado.setTitle("Paciente borrado");
            Stage stage = (Stage) pacienteBorrado.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/assets/user.png").toString()));
            pacienteBorrado.setHeaderText(null);
            pacienteBorrado.setContentText("Paciente borrado de forma exitosa");
            pacienteBorrado.showAndWait();
            tablaPacientes.getItems().remove(obj);
        }
    }
}


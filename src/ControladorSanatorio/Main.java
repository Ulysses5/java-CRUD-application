package ControladorSanatorio;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/VistaSanatorio/LoginVista.fxml"));
            AnchorPane ventana = (AnchorPane) loader.load();
            
            Scene scene = new Scene(ventana);
            
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("/assets/icon.png"));
            primaryStage.setTitle("Sanatorio Medico");
            primaryStage.centerOnScreen();
            primaryStage.show();            
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}

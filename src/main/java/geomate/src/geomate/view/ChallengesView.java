// /src/view/ChallengesView.java
package geomate.src.geomate.view;

import geomate.src.geomate.controller.ChallengesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ChallengesView {

    public Scene createChallengesScene(Stage primaryStage) {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ChallengesView.fxml"));
            //BorderPane root = loader.load();
            GridPane root = loader.load(); // Ahora carga como GridPane

            // Configurar el controlador para que tenga acceso al Stage principal
            ChallengesController challengesController = loader.getController();
            challengesController.setPrimaryStage(primaryStage);

            // Crear y retornar la escena
            return new Scene(root, 400, 300);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
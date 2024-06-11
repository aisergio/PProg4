// /src/view/WildcardsView.java
package geomate.src.geomate.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WildcardsView {

    public Scene createWildcardsScene(Stage primaryStage) {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WildcardsView.fxml"));
            BorderPane root = loader.load();

            // Crear y retornar la escena
            return new Scene(root, 400, 300);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
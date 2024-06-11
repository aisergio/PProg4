// /src/view/QuestionsView.java
package geomate.src.geomate.view;

import geomate.src.geomate.controller.QuestionsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class QuestionsView {

    public Scene createQuestionsScene(Stage primaryStage, String subject) {
        try {
            // Cargar el archivo FXML
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/fxml/QuestionsView.fxml"));
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("/geomate/src/fxml/QuestionsView.fxml"));
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("src/main/resources/fxml/QuestionsView.fxml"));
            BorderPane root = loader1.<BorderPane>load();

            // Configurar el controlador para que tenga acceso al Stage principal y la materia
            QuestionsController questionsController = loader1.getController();
            questionsController.setPrimaryStage(primaryStage);
            questionsController.setSubject(subject);

            // Crear y retornar la escena
            return new Scene(root, 400, 300);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
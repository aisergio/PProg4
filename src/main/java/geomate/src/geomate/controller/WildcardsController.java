// /src/controller/WildcardsController.java
package geomate.src.geomate.controller;

import geomate.src.geomate.view.WildcardsView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WildcardsController {

    @FXML
    private Button botonRegresarInicio;

    @FXML
    public void initialize() {
        botonRegresarInicio.setOnAction(event -> {
            Stage stage = (Stage) botonRegresarInicio.getScene().getWindow();
            showMainView(stage);
        });
    }

    private void showMainView(Stage primaryStage) {
        MainController mainController = new MainController();
        mainController.showMainView(primaryStage);
    }
}
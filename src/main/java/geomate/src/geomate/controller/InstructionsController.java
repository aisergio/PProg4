// /src/controller/InstructionsController.java
package geomate.src.geomate.controller;

import geomate.src.geomate.view.InstructionsView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InstructionsController {

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
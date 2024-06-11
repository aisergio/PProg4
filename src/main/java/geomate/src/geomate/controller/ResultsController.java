package geomate.src.geomate.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultsController {

    @FXML
    private Button btnRegresarInicio;
    @FXML
    private Label lblScore;

    private Stage primaryStage;

    public void setScore(int score) {
        lblScore.setText("Puntaje final: " + score);
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void initialize() {
        btnRegresarInicio.setOnAction(event -> {
            showMainView(primaryStage);
        });
    }

    private void showMainView(Stage primaryStage) {
        MainController mainController = new MainController();
        mainController.showMainView(primaryStage);
    }
}
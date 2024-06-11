package geomate.src.geomate.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import geomate.src.geomate.view.QuestionsView;

public class ChallengesController {

    @FXML
    private Button btnGeometry;

    @FXML
    private Button btnStatistics;

    @FXML
    private Button btnAlgebra;

    @FXML
    private Button btnTrigonometry;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void initialize() {
        btnGeometry.setOnAction(event -> showQuestionsScene("geometría"));
        btnStatistics.setOnAction(event -> showQuestionsScene("estadística"));
        btnAlgebra.setOnAction(event -> showQuestionsScene("álgebra"));
        btnTrigonometry.setOnAction(event -> showQuestionsScene("trigonometría"));
    }

    private void showQuestionsScene(String subject) {
        QuestionsView questionsView = new QuestionsView();
        Scene questionsScene = questionsView.createQuestionsScene(primaryStage, subject);
        primaryStage.setScene(questionsScene);
        primaryStage.setTitle("Preguntas");
        primaryStage.show();
    }
}
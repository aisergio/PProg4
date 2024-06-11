// /src/controller/MainController.java
package geomate.src.geomate.controller;

import geomate.src.geomate.view.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import geomate.src.geomate.view.ChallengesView;
import geomate.src.geomate.view.InstructionsView;
import geomate.src.geomate.view.WildcardsView;

public class MainController {

    @FXML
    private Button botonDesafios;

    @FXML
    private SplitMenuButton botonPerfil;

    @FXML
    private MenuItem opcionInstrucciones;

    @FXML
    private MenuItem opcionComodines;

    private MainController mainController;

    @FXML
    public void initialize() {
        // Configuración del botón "INICIAR DESAFIO"
        botonDesafios.setOnAction(event -> {
            Stage stage = (Stage) botonDesafios.getScene().getWindow();
            showChallengesView(stage);
        });

        // Configuración de las opciones del botón de perfil
        opcionInstrucciones.setOnAction(event -> {
            Stage stage = (Stage) botonPerfil.getScene().getWindow();
            showInstructionsView(stage);
        });

        opcionComodines.setOnAction(event -> {
            Stage stage = (Stage) botonPerfil.getScene().getWindow();
            showWildcardsView(stage);
        });

        // Iniciar la animación del botón "INICIAR DESAFIO"
        animarBotonDesafio();
    }

    public void showMainView(Stage primaryStage) {
        MainView mainView = new MainView();
        primaryStage.setScene(mainView.createMainScene());
        primaryStage.setTitle("Inicio");
        primaryStage.show();
    }

    private void showChallengesView(Stage primaryStage) {
        ChallengesView challengesView = new ChallengesView();
        primaryStage.setScene(challengesView.createChallengesScene(primaryStage));
        primaryStage.setTitle("Desafíos");
        primaryStage.show();
    }

    private void showInstructionsView(Stage primaryStage) {
        InstructionsView instructionsView = new InstructionsView();
        primaryStage.setScene(instructionsView.createInstructionsScene(primaryStage));
        primaryStage.setTitle("Instrucciones");
        primaryStage.show();
    }

    private void showWildcardsView(Stage primaryStage) {
        WildcardsView wildcardsView = new WildcardsView();
        primaryStage.setScene(wildcardsView.createWildcardsScene(primaryStage));
        primaryStage.setTitle("Comodines");
        primaryStage.show();
    }

    private void animarBotonDesafio() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.5), e -> botonDesafios.setTextFill(Color.GREEN)),
                new KeyFrame(Duration.seconds(1), e -> botonDesafios.setTextFill(Color.WHITE))
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
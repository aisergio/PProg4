package geomate.src.geomate.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import geomate.src.geomate.model.ConjuntoPreguntas;
import geomate.src.geomate.model.Pregunta;

import java.io.IOException;
import java.util.List;

public class QuestionsController {

    @FXML
    private Button btnSubmit;
    @FXML
    private Label lblScore;
    @FXML
    private Label lblQuestion; // Para mostrar el enunciado
    @FXML
    private RadioButton rbOption1;
    @FXML
    private RadioButton rbOption2;
    @FXML
    private RadioButton rbOption3;
    @FXML
    private RadioButton rbOption4;
    @FXML
    private ToggleGroup groupOpciones;

    private Stage primaryStage;
    private String subject;
    private List<Pregunta> preguntas;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private ConjuntoPreguntas conjuntoPreguntas; // Para cargar preguntas desde JSON

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @FXML
    public void initialize() {
        conjuntoPreguntas = new ConjuntoPreguntas();
        preguntas = conjuntoPreguntas.cargarPreguntas(subject); // Asume que tienes un método para cargar desde JSON
        mostrarPregunta();
    }


    private void mostrarPregunta() {
        Pregunta preguntaActual = preguntas.get(currentQuestionIndex);
        lblQuestion.setText(preguntaActual.getEnunciado());

        System.out.println(preguntaActual.getEnunciado());
        System.out.println(currentQuestionIndex);
        System.out.println(getClass().getResourceAsStream("/preguntas3.json"));

        if (!preguntaActual.getOpciones().isEmpty()) { // Comprueba si la lista de opciones no está vacía
            //rbOption1.setText(preguntaActual.getOpciones().get(0));
            //rbOption2.setText(preguntaActual.getOpciones().get(1));
            //rbOption3.setText(preguntaActual.getOpciones().get(2));
            //rbOption4.setText(preguntaActual.getOpciones().get(3));

            //rbOption1.setText("Opción 1");
            //rbOption2.setText("Opción 2");
            //rbOption3.setText("Opción 3");
            //rbOption4.setText("Opción 4");

        } else {
            // Si la lista de opciones está vacía, muestra un mensaje de error
            lblQuestion.setText("Error: No hay opciones disponibles para esta pregunta.");

            //rbOption1.setText("Opción 1");
            //rbOption2.setText("Opción 2");
            //rbOption3.setText("Opción 3");
            //rbOption4.setText("Opción 4");

        }
    }

        @FXML
    private void enviarRespuesta() {
        RadioButton selectedOption = (RadioButton) groupOpciones.getSelectedToggle();
        if (selectedOption != null) {
            String selectedAnswer = selectedOption.getText();
            Pregunta preguntaActual = preguntas.get(currentQuestionIndex);
            if (selectedAnswer.equals(preguntaActual.getRespuestaCorrecta())) {
                score++;
                lblScore.setText("Puntaje: " + score);
            }
            currentQuestionIndex++;

            if (currentQuestionIndex < preguntas.size()) {
                mostrarPregunta();
            } else {
                mostrarResultados();
            }
        }
    }

    private void mostrarResultados() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/geomate/view/results.fxml"));
            Parent root = loader.load();
            ResultsController resultsController = loader.getController();
            resultsController.setScore(score);
            resultsController.setPrimaryStage(primaryStage);
            primaryStage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
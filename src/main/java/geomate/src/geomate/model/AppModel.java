// /src/model/AppModel.java
package geomate.src.geomate.model;

import java.util.List;
import java.util.Arrays;

public class AppModel {

    // Atributos para contener los datos de la aplicación
    private List<String> challenges;
    private List<String> wildcards;
    private String instructions;

    // Constructor
    public AppModel() {
        // Inicializar los datos de ejemplo para desafíos, comodines e instrucciones
        this.challenges = Arrays.asList(
                "Desafío 1: Resuelve el problema de geometría...",
                "Desafío 2: Calcula el área del triángulo...",
                "Desafío 3: Encuentra el volumen del cubo..."
        );

        this.wildcards = Arrays.asList(
                "Comodín 1: Ayuda con la fórmula...",
                "Comodín 2: Explicación de teoría...",
                "Comodín 3: Pista adicional..."
        );

        this.instructions = "Para jugar, selecciona un desafío y usa los comodines si te quedas atascado.";
    }

    // Métodos para acceder a los datos
    public List<String> getChallenges() {
        return challenges;
    }

    public List<String> getWildcards() {
        return wildcards;
    }

    public String getInstructions() {
        return instructions;
    }

    // Métodos para actualizar los datos (en un escenario real, podría actualizarse desde una base de datos)
    public void setChallenges(List<String> challenges) {
        this.challenges = challenges;
    }

    public void setWildcards(List<String> wildcards) {
        this.wildcards = wildcards;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
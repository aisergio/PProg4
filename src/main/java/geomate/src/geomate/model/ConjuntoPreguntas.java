package geomate.src.geomate.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import geomate.src.geomate.model.Pregunta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ConjuntoPreguntas {

    public List<Pregunta> cargarPreguntas(String subject) {
        //System.out.println(getClass().getResourceAsStream("/resources/preguntas1.json"));
        System.out.println(getClass().getResourceAsStream("/preguntas3.json"));
        List<Pregunta> preguntas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/preguntas4.json"))))) {

            Gson gson = new GsonBuilder().create();
            Type preguntaListType = new TypeToken<List<Pregunta>>() {}.getType();
            preguntas = gson.fromJson(reader, preguntaListType);

            // Filtra las preguntas por materia
            List<Pregunta> filteredQuestions = new ArrayList<>();
            for (Pregunta pregunta : preguntas) {
                if (pregunta.getMateria().equals(subject)) {
                    filteredQuestions.add(pregunta);
                }
            }
            preguntas = filteredQuestions;

            // Mezcla las preguntas aleatoriamente
            Random random = new Random();
            for (int i = preguntas.size() - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                Pregunta temp = preguntas.get(index);
                preguntas.set(index, preguntas.get(i));
                preguntas.set(i, temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return preguntas;
    }
}
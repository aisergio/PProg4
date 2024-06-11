// /src/MainApp.java
package geomate.src.geomate;

import javafx.application.Application;
import javafx.stage.Stage;
import geomate.src.geomate.controller.MainController;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        MainController mainController = new MainController();
        mainController.showMainView(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
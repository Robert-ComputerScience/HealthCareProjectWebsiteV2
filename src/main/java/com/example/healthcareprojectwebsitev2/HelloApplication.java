package com.example.healthcareprojectwebsitev2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Create a scene with a generous default resolution before maximizing
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);

        stage.setTitle("Healthcare Dashboard App");
        // Set the stage to maximized to simulate a full-screen web browser experience
        stage.setMaximized(true);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
package main.Obliczenie;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
//import main.BazaDanych.BazaDanych;

import java.sql.*;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) throws SQLException {
            launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Pane mainPane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/main1.fxml")));
        Scene scene = new Scene(mainPane);
        stage.setScene(scene);
        stage.setTitle("Witaj w programie!");
        stage.show();
    }

}

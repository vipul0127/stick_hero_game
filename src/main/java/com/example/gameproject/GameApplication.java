package com.example.gameproject;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
//import javafx.scene.media.*;
public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        stage.setTitle("Stick Hero");
        Scene scene1 = new Scene(root);
        stage.setScene(scene1);
        stage.show();
//
//        Media media = new Media(MUSIC_FILE);
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//
//        playButton.setOnAction(e -> {
//            mediaPlayer.play();
//        });
//
//        stopButton.setOnAction(e -> {
//            mediaPlayer.stop();
//        });
   }


    public static void main(String[] args) {
        launch();
    }
}
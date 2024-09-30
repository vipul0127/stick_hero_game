//package com.example.gameproject;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.shape.Polygon;
//import javafx.stage.Stage;
//
//import java.util.Objects;
//
//public class MainController {
//
//    @FXML
//    private Button cherry_button;
//
//    @FXML
//    private Button help_button;
//
//    @FXML
//    private Button play_button;
//
//    @FXML
//    private Polygon play_triangle;
//
//    @FXML
//    private Button speaker_button;
//
//    @FXML
//    private Button stats_button;
//
//    @FXML
//    void cherry_click(MouseEvent event) {
//        System.out.println("hello game");
//    }
//
//    @FXML
//    void help_click(MouseEvent event) {
//
//    }
//
//    @FXML
//    void play_game(ActionEvent event) {
//
//        loadGameScene();
//
//    }
//
//    @FXML
//    void speaker_click(MouseEvent event) {
//
//    }
//
//    @FXML
//    void stats_click(MouseEvent event) {
//
//    }
//    private void loadGameScene() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
//            Parent gameRoot = loader.load();
//
//            // Access the controller of the game scene if needed
//            Game_Controller gameController = loader.getController();
//
//            // Set the game scene
//            Scene gameScene = new Scene(gameRoot);
//            Stage primaryStage = (Stage) play_button.getScene().getWindow();
//            primaryStage.setScene(gameScene);
//
//            // Initialize the game (if needed)
//            gameController.initializeGame();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

//package com.example.gameproject;
//
//import javafx.animation.AnimationTimer;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.shape.Circle;
//import javafx.scene.shape.*;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.ResourceBundle;
//
//public class GameController implements Initializable {
//
//    AnimationTimer gameloop;
//    @FXML
//    public Polygon play_triangle;
//
//    @FXML
//    private AnchorPane game_plane;
//    @FXML
//    public Button play_button;
//    @FXML
//    private Text Score_text;
//
//    @FXML
//    private Text cherry_text;
//
//    @FXML
//    private Button hero_button;
//
//    @FXML
//    private ImageView hero_img1;
//
//    @FXML
//    private Line my_stick;
//
//    @FXML
//    private Button pause_button;
//    @FXML
//    private Button cherry_button;
//
//    @FXML
//    private Button help_button;
//
//
//
//    @FXML
//    private Button speaker_button;
//
//    @FXML
//    private Button stats_button;
//    private Hero super_hero;
//    private Cherry game_cherry;
//    private Stick recent_stick;
//    private Wall game_rectangles;
//    private Score individual_score;
//    ArrayList<Rectangle> Rectangles = new ArrayList<>();
//    @Override
//
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//
//
//
//    }
//
//    @FXML
//    void cherry_click(MouseEvent event) {
//
//    }
//
//    @FXML
//    void help_click(MouseEvent event) {
//
//    }
//
//
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
//
//    public void play_game(ActionEvent e) throws IOException {
//        play_button.setGraphic(new Pane(play_triangle));
//        Stage stage = (Stage) play_button.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
//        stage.setTitle("GAME START");
//        stage.setScene(new Scene(root));
//        super_hero = new Hero(hero_img1,hero_img1.getX(), hero_img1.getY());
//        recent_stick=new Stick(my_stick,my_stick.getEndY()-my_stick.getStartY());
//        game_cherry= new Cherry(0,0);
//        game_rectangles = new Wall(game_plane,game_plane.getHeight(),game_plane.getWidth());
//        individual_score = new Score(super_hero,0,0);
//        gameloop = new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                update();
//            }
//        };
////        load();
//
//        gameloop.start();
//
//
//
//    }
//    private void update() throws IOException {
//        if(pointChecker(Rectangles, bird)){
//            ++;
//            score.setText(String.valueOf(scoreCounter));
//        }
//
//        obstaclesHandler.moveObstacles(Rectangles);
//        if(gameTime % 500 == 0){
//            obstacles.addAll(obstaclesHandler.createObstacles());
//        }
//
//        if(birdComponent.isBirdDead(Rectangles, plane)){
//            endgame();
//        }
//    }
//
//    @FXML
//    void mouse_Released(MouseEvent event) {
//        recent_stick.rotate();
//
//
//    }
//
//    @FXML
//    void mouse_dragged(MouseEvent event) {
//        recent_stick.grow();
//
//
//
//    }
//    private boolean pointChecker(ArrayList<Rectangle> obstacles, Rectangle bird){
//        for (Rectangle obstacle: obstacles) {
//            int birdPositionX = (int) (bird.getLayoutX() + bird.getX());
//            if(((int)(obstacle.getLayoutX() + obstacle.getX()) == birdPositionX)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public void endgame() throws IOException {
//        Stage stage = (Stage) play_button.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("scene2.fxml"));
//        stage.setTitle("end game");
//        stage.setScene(new Scene(root));
//
//
//    }
//
//}

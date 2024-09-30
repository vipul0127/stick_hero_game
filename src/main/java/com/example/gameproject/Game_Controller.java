package com.example.gameproject;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.String.valueOf;

public class Game_Controller {

    @FXML
    private Text Score_text;

    @FXML
    private Text cherry_text;
    @FXML
    private Rectangle wall1;

    @FXML
    private Rectangle wall2;

    @FXML
    private Rectangle wall3;

    @FXML
    private AnchorPane game_plane;

    @FXML
    private Button hero_button;

    @FXML
    private Button jump_button;

    @FXML
    private Button restart_button;

    @FXML
    private Button revive_button;


    @FXML
    private ImageView hero_img1;

    @FXML
    private ImageView cherry;
    @FXML
    private Group Exit_group;
    @FXML
    private Group paused_group;
    @FXML
    private Group revival_group;
    @FXML
    private Text best_score;
    @FXML
    private Text over_score;
    @FXML
    private Text game_status;

    @FXML
    private Line my_stick;

    @FXML
    private Button pause_button;
    private Hero super_hero;
    private Cherry game_cherry;
    private Stick recent_stick;
    private Wall game_walls;
    private Score individual_score;
    private Rotate rotate;
    ArrayList<Wall> walls = new ArrayList<>();
    private AnimationTimer gameloop;
    Random rand = new Random();
    int random=10;
    Boolean is_animating = false;
    Boolean game_over = false;
    @FXML
    private Button cherry_button;

    @FXML
    private Button help_button;

    @FXML
    private Button play_button;

    @FXML
    private Polygon play_triangle;

    @FXML
    private Button speaker_button;

    @FXML
    private Button stats_button;

    Scene gameScene;

    @FXML
    void cherry_click(MouseEvent event) {
        System.out.println("hello game");
    }

    @FXML
    void help_click(MouseEvent event) {

    }

    @FXML
    void play_game(ActionEvent event) {

        gameScene = loadGameScene();

    }

    @FXML
    void speaker_click(MouseEvent event) {

    }

    @FXML
    void stats_click(MouseEvent event) {

    }
    private Scene loadGameScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
            Parent gameRoot = loader.load();

            // Access the controller of the game scene if needed
            Game_Controller gameController = loader.getController();

            // Set the game scene
            Scene gameScene = new Scene(gameRoot);
            Stage primaryStage = (Stage) play_button.getScene().getWindow();
            primaryStage.setScene(gameScene);

            // Initialize the game (if needed)
            gameController.initializeGame();

            gameScene.setOnKeyPressed(event -> {
                if (event.getCode().toString().equals("SPACE")) {

                    // Add your code to handle the spacebar press event here
                    System.out.println("pressed space");
                    hero_jump.start();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameScene;
    }



    private Scene reloadGameScene() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
                Parent gameRoot = loader.load();

                // Access the controller of the game scene if needed
                Game_Controller gameController = loader.getController();

                // Set the game scene
                Scene gameScene = new Scene(gameRoot);
                Stage primaryStage = (Stage) restart_button.getScene().getWindow();
                primaryStage.setScene(gameScene);

                // Initialize the game (if needed)
                gameController.initializeGame();

                gameScene.setOnKeyPressed(event -> {
                    if (event.getCode().toString().equals("SPACE")) {

                        // Add your code to handle the spacebar press event here
                        System.out.println("pressed space");
                        hero_jump.start();
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
            return gameScene;
    }


boolean first = true;

    public void initializeGame(){
//        System.out.println("hello game");
        super_hero = new Hero(hero_img1,0,0);
        recent_stick=new Stick(my_stick,my_stick.getEndY()-my_stick.getStartY());
        if(!first){
            recent_stick.endrestore();
        }
//        System.out.println(recent_stick.getStick().getEndX());

//        game_cherry= Cherry.getInstance(cherry);
        game_cherry = new Cherry(cherry);
        game_walls = new Wall(wall1,wall2,wall3);
        game_cherry.create(game_walls);


//        System.out.println(wall1.getX());
//        System.out.println(wall2.getX());
//        System.out.println(game_walls.distance);
//        System.out.println(game_walls.width2);


        individual_score = Score.newGame();
        String che = valueOf(individual_score.getCherries());
        cherry_text.setText(che);
        String sco = valueOf(individual_score.getPoints());
        Score_text.setText(sco);

        gameloop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
                check();
                if(game_over){
                    this.stop();
                    showGameOverScene();
                }
            }
        };
        gameloop.start();


    }


    public void reinitializeGame(){
//        System.out.println("hello game");
        super_hero.setX(0);
        super_hero.setY(0);
        recent_stick.endrestore();

        game_cherry= Cherry.getInstance(cherry);

//        game_walls = new Wall(wall1,wall2,wall3);
        game_cherry.create(game_walls);


//        System.out.println(wall1.getX());
//        System.out.println(wall2.getX());
//        System.out.println(game_walls.distance);
//        System.out.println(game_walls.width2);


        individual_score.reset_points();
        String che = valueOf(individual_score.getCherries());
        cherry_text.setText(che);
        String sco = valueOf(individual_score.getPoints());
        Score_text.setText(sco);

        gameloop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
                check();
                if(game_over){
                    this.stop();
                    showGameOverScene();
                }
            }
        };
        gameloop.start();


    }

    public void reinitializeGameForrevival(){
//        System.out.println("hello game");
        super_hero.setX(0);
        super_hero.setY(0);
        recent_stick.endrestore();

        game_cherry= Cherry.getInstance(cherry);

//        game_walls = new Wall(wall1,wall2,wall3);
        game_cherry.create(game_walls);


//        System.out.println(wall1.getX());
//        System.out.println(wall2.getX());
//        System.out.println(game_walls.distance);
//        System.out.println(game_walls.width2);


//        individual_score = Score.newGame(super_hero);
        String che = valueOf(individual_score.getCherries());
        cherry_text.setText(che);
        String sco = valueOf(individual_score.getPoints());
        Score_text.setText(sco);

        gameloop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
                check();
                if(game_over){
                    this.stop();
                    showGameOverScene();
                }
            }
        };
        gameloop.start();


    }

//    node.setOnKeyPressed(event -> {
//        if (event.getCode() == KeyCode.UPPER) {
//
//        } else if (event.getCode() == KeyCode.LOWER) {
//
//        }
//    });



    AnimationTimer stick_animation = new AnimationTimer() {

        @Override
        public void handle(long now) {
            recent_stick.grow();
        }
    };

    AnimationTimer hero_jump = new AnimationTimer() {
        boolean upwards = true;
        @Override
        public void handle(long now) {
            is_animating = true;
            if(super_hero.getY()<=-35){
                upwards=false;
            }
            if(upwards){
                super_hero.moveUp();
            }
            else{
                super_hero.moveDown();
            }
            if(super_hero.getY()==0&&!upwards){
                upwards = true;
                is_animating = false;
                this.stop();
            }
//            System.out.println(super_hero.getY());
        }
    };

    AnimationTimer stick_rotation_animation = new AnimationTimer() {

        @Override
        public void handle(long now) {
            double angle = recent_stick.rotate(rotate);
            System.out.println("angle: "+angle);
            if(angle == 90){
                this.stop();
                hero_move_on_stick_animation.start();
            }
        }
    };



    AnimationTimer reset = new AnimationTimer() {

        @Override
        public void handle(long now) {
            is_animating = true;
            super_hero.moveLeft();
            game_walls.moveLeft();

            if(super_hero.getX()==0){
//                game_walls.recreate();
//                wall_bringer.start();
                recent_stick.getStick().setVisible(true);
                is_animating = false;
                reset.stop();
            }
        }
    };

    AnimationTimer wall_bringer = new AnimationTimer() {

        @Override
        public void handle(long now){
            is_animating = true;
            game_walls.bringer();
            if(random==game_walls.wall2.getX()){
                game_cherry.create(game_walls);
                is_animating = false;
                this.stop();
            }
        }
    };


    AnimationTimer hero_move_on_wall_animation = new AnimationTimer() {

        @Override
        public void handle(long now) {
            is_animating = true;
            super_hero.moveRight();
//            System.out.println(super_hero.getX()-game_walls.distance-game_walls.width2+ recent_stick.length);
            if(abs(super_hero.getX()-game_walls.distance-game_walls.width2)<=0.5){
                individual_score.setPoints(individual_score.getPoints()+1);
                String sco = valueOf(individual_score.getPoints());
                Score_text.setText(sco);

                game_cherry.cherry.setVisible(false);
                recent_stick.restore();
                recent_stick.getStick().setVisible(false);
                game_walls.recreate();
                random = 100+rand.nextInt(250);
//                System.out.println(random);
                wall_bringer.start();
                reset.start();
                is_animating=false;
                this.stop();
            }
        }
    };


    AnimationTimer hero_falling_animation = new AnimationTimer() {

        @Override
        public void handle(long now) {
            is_animating = true;
            super_hero.moveDown();
            if(super_hero.getY()==300 || super_hero.getY()==0){
                if(super_hero.getY()==300){
                    showGameOverScene();
                }
                is_animating = false;
                this.stop();
            }
        }
    };

    AnimationTimer hero_move_on_stick_animation = new AnimationTimer() {

        @Override
        public void handle(long now) {
            is_animating = true;
            super_hero.moveRight();
            if(abs(super_hero.getX()-recent_stick.length)<0.5){
                if(game_walls.distance<recent_stick.length && game_walls.distance+game_walls.width2>recent_stick.length){
                    hero_move_on_wall_animation.start();
                    is_animating = false;
                    this.stop();
                }
                else{
                    if(super_hero.is_fliped){
                        super_hero.flip();
                    }
                    hero_falling_animation.start();
                    //                        game_over();
//                    showGameOverScene();
                    Timeline timeline = recent_stick.rotate();
                    timeline.setOnFinished(event->{
                        recent_stick.getStick().setVisible(false);
                    });
                    is_animating=false;
                    this.stop();
                }

            }

        }
    };


    public void update(){ // Applied template design pattern in this case.
        recent_stick.render();
        super_hero.render();
        game_walls.render();
        game_cherry.render();
    }

    public void check(){
        boolean collided = game_cherry.collided(super_hero);
        if(collided){
            individual_score.setCherries(individual_score.getCherries()+1);
            String che = valueOf(individual_score.getCherries());
            cherry_text.setText(che);
        }


        collided = game_walls.collided(super_hero);

        if(collided){
            if(super_hero.is_fliped){
                super_hero.flip();
            }
            hero_move_on_wall_animation.stop();
            hero_move_on_stick_animation.stop();
            Timeline timeline = recent_stick.rotate();
            timeline.setOnFinished(event->{
                recent_stick.getStick().setVisible(false);
            });

            hero_falling_animation.start();
        }
    }

    @FXML
    void mouse_Released(MouseEvent e) throws InterruptedException {
        if(!is_animating) {
            is_animating = true;
            stick_animation.stop();
//        Thread t1 = new Thread(recent_stick);
//        t1.start();
//        t1.join();
//        rotate = new Rotate();
            Timeline timeline = recent_stick.rotate();
            timeline.setOnFinished(event -> {
                is_animating = false;
                hero_move_on_stick_animation.start();
            });
//        stick_rotation_animation.start();
//        hero_move_animation.start();
        }
    }

    @FXML
    void mouse_dragged(MouseEvent event) {
        if(!is_animating) {
            stick_animation.start();
        }
    }


    @FXML
    void jump(ActionEvent event) throws IOException {
        if(super_hero.getY()==0) {
            hero_jump.start();
        }
    }



    @FXML
    void flip(ActionEvent event) throws IOException {
        if(super_hero.getX()>0 && super_hero.getX()<game_walls.wall2.getX() && (super_hero.getY()==0 || super_hero.getY()==35)) {
            super_hero.flip();
        }
    }


    @FXML
    void restart(ActionEvent event) throws IOException {
//        reloadGameScene();
        Exit_group.setVisible(false);
        paused_group.setVisible(false);
        this.reinitializeGame();
    }


    @FXML
    void pause_game(ActionEvent event) throws IOException {
        paused_group.setVisible(true);
    }

    @FXML
    void resume_game(ActionEvent event) throws IOException{
        paused_group.setVisible(false);
    }

    @FXML
    void toggle_sound(ActionEvent event) throws IOException{

    }

    @FXML
    public void revive(ActionEvent event){
        if(individual_score.getCherries()>=3) {
            individual_score.setCherries(individual_score.getCherries()-3);
            this.reinitializeGameForrevival();
            super_hero.setY(-300);
            super_hero.setX(0);
            hero_falling_animation.start();
            Exit_group.setVisible(false);
        }
    }

    @FXML
    public void exit(ActionEvent event) throws IOException {
        gameloop.stop();
        game_cherry = Cherry.getInstance(cherry);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        Parent gameRoot = loader.load();

        // Access the controller of the game scene if needed
        Game_Controller gameController = loader.getController();

        // Set the game scene
        Scene gameScene = new Scene(gameRoot);
        Stage primaryStage = (Stage) Exit_group.getScene().getWindow();
        primaryStage.setScene(gameScene);

        // Initialize the game (if needed)
//        gameController.initializeGame();
    }

    public void save(){
        DataSaver data = new DataSaver(super_hero,game_walls,recent_stick,individual_score);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SaveFile.ser"))) {
            oos.writeObject(data);
            System.out.println("Object written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void load(){
        DataSaver data = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SaveFile.ser"))) {
            data = (DataSaver) ois.readObject();
            System.out.println("Object loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        individual_score = data.score;
        if(paused_group.isVisible()){
            paused_group.setVisible(false);
        }
        if(Exit_group.isVisible()){
            this.reinitializeGameForrevival();
            super_hero.setY(-300);
            super_hero.setX(0);
            hero_falling_animation.start();
            Exit_group.setVisible(false);
        }
    }

    public void showGameOverScene() {
        gameloop.stop();
        over_score.setText(valueOf(individual_score.getPoints()));
        Score.highest = Math.max(Score.highest, individual_score.getPoints());
        best_score.setText(valueOf(Score.highest));

        Exit_group.setVisible(true);
        if(individual_score.getCherries()>=3){
            revival_group.setOpacity(1);
        }
        else {
            revival_group.setOpacity(0.25);
        }
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene3.fxml"));
//            Parent root = loader.load();
//
//            Stage gameOverStage = new Stage();
//            gameOverStage = (Stage) hero_button.getScene().getWindow();
//            Scene scene = new Scene(root);
//            gameOverStage.setScene(scene);
//
//            // Set the position of the "GAME OVER" stage relative to the main stage (adjust as needed)
////                gameOverStage.setX(primaryStage.getX() + 50);
////                gameOverStage.setY(primaryStage.getY() + 50);
//
//            System.out.println(gameOverStage.getOpacity());
//
//
//            gameOverStage.show();
//        } catch (IOException e) {
//            e.printStackTrace(); // Handle the exception according to your application's needs
//        }
    }
}

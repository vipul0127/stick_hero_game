package com.example.gameproject;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.io.Serializable;

public class Stick implements StickMethods, Renderable,Runnable, Serializable {

    double length;
    private Line stick;

    public double getX_end() {
        return x_end;
    }

    public void setX_end(double x_end) {
        this.x_end = x_end;
    }

    public double getY_end() {
        return y_end;
    }

    public void setY_end(double y_end) {
        this.y_end = y_end;
    }

    private double x_end;
    private double y_end;
    private double x_start;
    private double y_start;

    public Line getStick() {
        return stick;
    }

    public void setX_start(double x_start) {
        this.x_start = x_start;
    }

    public void setY_start(double y_start) {
        this.y_start = y_start;
    }

    public double getX_start() {
        return x_start;
    }

    public double getY_start() {
        return y_start;
    }

    public Stick(Line newline, double len){
        this.length=len;
        this.stick=newline;
        x_end = stick.getEndX();
        y_end = stick.getEndY();
        x_start = stick.getStartX();
        y_start = stick.getStartY();
    }
    public void grow() {
        this.setY_end(this.y_end-1);
//        stick.setEndY( stick.getEndY() -1);
    }

    @Override
    public void render(){
        stick.setEndY(this.y_end);
        stick.setEndX(this.x_end);
        stick.setStartY(this.y_start);
        stick.setStartX(this.x_start);
        this.length = stick.getStartY()-stick.getEndY();
    }
    public boolean stick_range(){
        return stick.getEndY() > 0;
    }

    public void restore() {

        this.setY_start(0);
        this.setY_end(0);
        this.setX_start(0);
        this.setX_end(0);

        Rotate rotate = new Rotate(0, stick.getStartX(), stick.getStartY());
        stick.getTransforms().add(rotate);
        rotate.setAngle(-90);
    }

    public void endrestore() {

        this.setY_start(0);
        this.setY_end(0);
        this.setX_start(0);
        this.setX_end(0);

        Rotate rotate = new Rotate(0, stick.getStartX(), stick.getStartY());
        stick.getTransforms().add(rotate);
        rotate.setAngle(-180);
        stick.setVisible(true);
    }



    public Timeline rotate() {
        Line line = stick;
//        line.setStrokeWidth(10);
//        line.setStroke(Color.BLACK);

        // Create a Rotate transformation with a pivot at the lower end
        Rotate rotate = new Rotate(0, stick.getStartX(), stick.getStartY());
        line.getTransforms().add(rotate);

        // Create a Timeline for animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(0.8), new KeyValue(rotate.angleProperty(), 90))
        );

        timeline.play();
        return timeline;
       // primaryStage.setScene(scene);

    }
    public double rotate(Rotate rot){
        Rotate rotate = rot;
        rotate.setPivotX(stick.getStartX());
        rotate.setPivotY(stick.getStartY());
        stick.getTransforms().add(rotate);

        rotate.setAngle(rotate.getAngle()+90);
        return rotate.getAngle();
    }

    public boolean isEnough() {
        return false;
    }



    @Override
    public void run() {
        Line line = stick;
//        line.setStrokeWidth(10);
        line.setStroke(Color.BLACK);

        // Create a Rotate transformation with a pivot at the lower end
        Rotate rotate = new Rotate(0, stick.getStartX(), stick.getStartY());
        line.getTransforms().add(rotate);

        // Create a Timeline for animation
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotate.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1.2), new KeyValue(rotate.angleProperty(), 90))
        );


        timeline.play();

        // primaryStage.setScene(scene);
    }
}

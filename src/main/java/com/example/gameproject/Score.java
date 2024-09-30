package com.example.gameproject;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;

import java.io.Serializable;

public class Score implements Serializable {
    public int points;
    public int cherries=0;

    public static int highest =0;
    public Score(int x,int y){
        this.points = x;
        this.cherries = y;
    }
    public static Score newGame(){
        Score sc = new Score(0,0);
        return sc;
    }

    public void reset_points(){
        this.points=0;
    }

    public int getPoints() {

        return points;
    }

    public void setPoints(int points) {

        this.points = points;
    }

    public int getCherries() {

        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }
}

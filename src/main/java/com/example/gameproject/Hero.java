package com.example.gameproject;

import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

import java.io.Serializable;

public class Hero implements Movement,Renderable,Revival, Serializable {
    Boolean is_fliped = false;

    private double x,y; // position

    public Cordinate centre;
    public ImageView my_hero;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Hero(ImageView hro, double x, double y) {
        this.x = x;
        this.y = y;
        this.centre = new Cordinate(x,y);
        this.my_hero= hro;
    }

    public void moveUp() {
        this.setY(this.getY()-2);

    }

    public void moveDown() {
        this.setY(this.getY()+1);
    }


    public void moveRight() {
        this.setX(this.getX()+1);
    }

    public void moveLeft(){
        this.setX(this.getX()-1);
    }


    public void flip() {
        Rotate rotate = new Rotate(180,this.my_hero.getFitWidth()/2,this.my_hero.getFitHeight());

        Scale fliphorizontal = new Scale(-1,1,this.my_hero.getFitWidth()/2,0);

        this.my_hero.getTransforms().add(rotate);
        this.my_hero.getTransforms().add(fliphorizontal);
        is_fliped = !is_fliped;
        System.out.println(x+","+y);
    }

    public void jump() {

    }


    public void revive() {

    }

    public void restoreGameVariables() {

    }

    @Override
    public void render(){
        this.my_hero.setY(this.y);
        this.my_hero.setX(this.x);
        this.centre.x = this.x;
        this.centre.y = this.y;
    }
}

package com.example.gameproject;

import javafx.scene.shape.Rectangle;

import java.io.Serializable;
import java.util.Random;

public class Wall implements Renderable,Collidable, Serializable {
    Rectangle wall1;
    Rectangle wall2;
    Rectangle wall3;
    public double width1;
    public double width2;
    public double width3;
    public double distance;

    public double x,y; // position (centre)

    public Cordinate centre1;
    public Cordinate centre2;
    public Cordinate centre3;

    public Cordinate start1;
    public Cordinate start2;
    public Cordinate start3;
    public Cordinate end1;
    public Cordinate end2;
    public Cordinate end3;
    Random random = new Random();



    public Wall(Rectangle wall1, Rectangle wall2, Rectangle wall3){
        this.wall1 = wall1;
        this.wall2 = wall2;
        this.wall3 = wall3;
        this.width1 = wall1.getWidth();
        this.width2 = wall2.getWidth();
        this.width3 = wall3.getWidth();
        this.start1 = new Cordinate(wall1.getX(),wall1.getY());
        this.start2 = new Cordinate(wall2.getX(),wall2.getY());
        this.start3 = new Cordinate(wall3.getX(),wall3.getY());
        this.end1 = new Cordinate(wall1.getX()+width1,wall1.getY());
        this.end2 = new Cordinate(wall2.getX()+width2,wall2.getY());
        this.end3 = new Cordinate(wall3.getX()+width3,wall3.getY());
        this.centre1 = new Cordinate(wall1.getX()+width1/2,wall1.getY());
        this.centre2 = new Cordinate(wall2.getX()+width2/2,wall2.getY());
        this.centre3 = new Cordinate(wall3.getX()+width3/2,wall3.getY());

        this.distance = wall2.getX()-wall1.getX()-width1;
    }


//    public void setCentre(double x,double y){
//        this.centre = new Cordinate(x,y);
//    }
//    public void setStart(double x,double y){
//        this.start = new Cordinate(x-this.width,y);
//    }
//    public void setEnd(double x,double y){
//        this.end = new Cordinate(x+this.width,y);
//    }
//
//    public ArrayList<Rectangle> createObstacles(int x,double y){
//        if(x!=0 && y!=0){
//            int width = random.nextInt((int)(40)) + 50;
//            double xPos = planeWidth;
//
//        }
//
//        int width = x;
//        double xPos = y;
//
//        double recHeight = 206;
//
//
//        //                                     x      y   width   height
//        Rectangle rectangleTop = new Rectangle(xPos +20,planeHeight-recHeight,10,7);
//        rectangleTop.setFill(Color.BLACK);
//        Rectangle rectanglemiddle = new Rectangle(xPos, planeHeight-recHeight, width, recHeight);
//        rectanglemiddle.setFill(Color.BLUE);
//
//        plane.getChildren().addAll(rectangleTop,rectanglemiddle);
//        return new ArrayList<>(Arrays.asList(rectangleTop,rectanglemiddle));
//    }


    public void moveLeft(){
        wall1.setX(wall1.getX()-1);
        wall3.setX(wall3.getX()-1);
    }

    public void bringer(){
        wall2.setX(wall2.getX()-1);
    }


    @Override
    public void render(){
        this.width1 = wall1.getWidth();
        this.width2 = wall2.getWidth();
        this.width3 = wall3.getWidth();
        this.start1 = new Cordinate(wall1.getX(),wall1.getY());
        this.start2 = new Cordinate(wall2.getX(),wall2.getY());
        this.start3 = new Cordinate(wall3.getX(),wall3.getY());
        this.end1 = new Cordinate(wall1.getX()+width1,wall1.getY());
        this.end2 = new Cordinate(wall2.getX()+width2,wall2.getY());
        this.end3 = new Cordinate(wall3.getX()+width3,wall3.getY());
        this.centre1 = new Cordinate(wall1.getX()+width1/2,wall1.getY());
        this.centre2 = new Cordinate(wall2.getX()+width2/2,wall2.getY());
        this.centre3 = new Cordinate(wall3.getX()+width3/2,wall3.getY());

        this.distance = wall2.getX()-wall1.getX()-width1;
    }
    public void recreate(){

        Random rand = new Random();
        double width = 20+rand.nextDouble(100);
        wall3.setX(500);
        wall3.setWidth(width);
        Rectangle temp = wall1;
        wall1 = wall2;
        wall2 = wall3;
        wall3=temp;
    }

    @Override
    public boolean collided(Hero hero) {
        if(hero.is_fliped){
            System.out.println(hero.getX()-this.wall2.getX()+84);
            if(hero.getX()-this.wall2.getX()+84>-4){
                System.out.println(hero.getX()-this.wall2.getX());
                return true;
            }
        }
        return false;
    }
//    public void moveObstacles(ArrayList<Rectangle> obstacles){
//
//        ArrayList<Rectangle> outOfScreen = new ArrayList<>();
//
//        for (Rectangle rectangle: obstacles) {
//            moveRectangle(rectangle, - 0.75);
//
//            if(rectangle.getX() <= -rectangle.getWidth()){
//                outOfScreen.add(rectangle);
//            }
//        }
//        obstacles.removeAll(outOfScreen);
//        plane.getChildren().removeAll(outOfScreen);
//    }

//    private void moveRectangle(Rectangle rectangle, double amount){
//        rectangle.setX(rectangle.getX() + amount);
//    }
}

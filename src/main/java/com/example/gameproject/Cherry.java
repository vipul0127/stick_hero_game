package com.example.gameproject;

import javafx.scene.image.ImageView;

import java.io.Serializable;
import java.util.Random;

public class Cherry implements Renderable, Collidable, Serializable {  //This is a singleton class.
    public double x,y;
    private static Cherry game_cherry=null;
    public final ImageView cherry;
    public Cordinate centre;
    public void setCentre(double x,double y){
        this.centre= new Cordinate(x,y);
    }

    public Cherry(ImageView cher) {
        this.cherry = cher;
        this.x = cher.getX();
        this.y = cher.getY();
        this.setCentre(x,y);
    }

    public static Cherry getInstance(ImageView cher){
        if(Cherry.game_cherry == null){
            game_cherry = new Cherry(cher);
        }
        return game_cherry;
    }



    public void create(Wall gamewalls){
        Random rand = new Random();
        int avail = rand.nextInt(0,3);
        this.cherry.setVisible(avail != 0);
        int y_pos = rand.nextInt(4);
        if(y_pos==0){
            this.y=-35;
        } else if (y_pos==1) {
            this.y=0;
        } else if(y_pos==2){
            this.y=35;
        }else {
            this.y=70;
        }

        double min = 10;
        double max = gamewalls.wall2.getX();

        double x_pos = min+rand.nextDouble(gamewalls.distance);
//        System.out.println(gamewalls.distance);
        this.x = x_pos;
    }

    @Override
    public void render(){
        centre.x = this.x;
        centre.y = this.y;
        cherry.setX(x);
        cherry.setY(y);

    }

    @Override
    public boolean collided(Hero hero) {
        if(cherry.isVisible()) {
//            System.out.println("Y: "+hero.centre.y);
//            System.out.println("X: "+hero.centre.x);
            if(!hero.is_fliped){
                cherry.setVisible(!(this.centre.distance(hero.centre) < 20));
                return this.centre.distance(hero.centre) < 20;
            }
            else{
                Cordinate temp = new Cordinate(hero.getX(), hero.getY()+35);
                cherry.setVisible(!(this.centre.distance(temp) < 20));
                return this.centre.distance(temp) < 20;
            }
//            System.out.println(this.centre.distance(hero.centre));

        }
        return false;
    }
}

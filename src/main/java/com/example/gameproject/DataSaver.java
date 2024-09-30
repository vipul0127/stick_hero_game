package com.example.gameproject;

import java.io.Serializable;

public class DataSaver implements Serializable {
//    Hero hero;
//    Wall walls;
//    Stick stick;
    Score score;

    public DataSaver(Hero hero, Wall walls, Stick stick, Score score) {
//        this.hero = hero;
//        this.walls = walls;
//        this.stick = stick;
        this.score = score;
    }


}

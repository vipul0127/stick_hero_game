package com.example.gameproject;

import java.io.Serializable;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class Cordinate implements Serializable
{
   public double x,y;

   public Cordinate(double x, double y) {
      this.x = x;
      this.y = y;
   }

   public double distance(Cordinate c){
      double distance = pow(pow(this.x-c.x,2)+pow(this.y-c.y,2),0.5);
      return distance;
   }

   @Override
   public boolean equals(Object obj) {
      Cordinate c2 = (Cordinate) obj;
      return (abs(this.x-c2.x)<0.5 && abs(this.y-c2.y)<0.5);
   }
}

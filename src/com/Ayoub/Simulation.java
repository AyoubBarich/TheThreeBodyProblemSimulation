package com.Ayoub;

import java.util.TimerTask;

public abstract class Simulation extends TimerTask {
    public static Corps Sun;
    public static Corps moon;
    public static Corps earth;

   public static Corps setAstre(String name , int[]position, int mass, int[] vitess){
       return   new Corps(name, position, mass, vitess);
   }
   public static double getDistance (double [] point1, double[] point2 ) {
       double distance = Math.pow(Math.pow(point1[0]-point2[0],2)+Math.pow(point1[1]-point2[1],2),1.0/2);
       return distance;


   }

}

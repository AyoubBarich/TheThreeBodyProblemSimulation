package com.Ayoub;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.TimerTask;

public abstract class Simulation extends TimerTask {
    public  static int n =15;
    public static final double G = 1;
    int scope = 1;
    double w = 0.729;
    double c1 = 1.49445;
    double c2 = 1.49445;
    double[][] v = new double[n][3];

    double[] vmax = new double[]{scope*0.01,scope*0.01,scope*0.01};
    double[] vmin = new double[]{-scope*0.01,-scope*0.01,-scope*0.01};

    static ArrayList<Corps> allBodies= new ArrayList<>() ;
    static ArrayList<Circle> allCircles = new ArrayList<>();




    static double t = 0.001d;

   public static void setAstre(String name , double[]position, int mass, int[] vitess, int rayon, Color color){
       allBodies .add(new Corps(name, position, mass, vitess,rayon,color));
       allCircles.add(new Circle());

   }
   public static double getDistance (double [] point1, double[] point2 ) {
       return Math.pow(Math.pow(point1[0]-point2[0],2)+Math.pow(point1[1]-point2[1],2),1.0/2);
   }
   public static double[] getAcceleration (Corps tar,Corps b){
       double G = 6.67*Math.pow(10,-2);
       double distance = getDistance(tar.pos,b.pos);
       double acceleration = G*b.mass*Math.pow(10,6)/Math.pow(distance,2);
       return new double[]{acceleration*(b.pos[0]-tar.pos[0])/distance,acceleration*(b.pos[1]-tar.pos[1])/distance};
   }
   public static double[] getPosition(Corps tar, Corps b1, Corps b2){
       double[] acc = new  double[]{getAcceleration(tar,b1)[0]+getAcceleration(tar,b2)[0],getAcceleration(tar,b1)[1]+getAcceleration(tar,b2)[1] };
       return new double[]{tar.pos[0]+tar.vitesse[0]*t+acc[0]*Math.pow(t,2)/2,tar.pos[1]+tar.vitesse[1]*t+acc[1]*Math.pow(t,2)/2 };
   }
   public static  double[] getVitesse(Corps tar , Corps b1 , Corps b2){
       double[] acc = new double[]{getAcceleration(tar,b1)[0]+getAcceleration(tar,b2)[0],getAcceleration(tar,b1)[1]+getAcceleration(tar,b2)[1]};
       return new double[]{tar.vitesse[0]+acc[0]*t,tar.vitesse[1]+acc[0]*t};


   }
   public static  double[] getForce (Corps source,Corps Applique){

       return new double[]{ source.mass*getAcceleration(source,Applique)[0],source.mass*getAcceleration(source,Applique)[0]};

   }








}

package com.Ayoub;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public  class Plan   {
    public int Xmax;
    public int Ymax;
    public static double [] Pos;
    public static double[] Pos1;
    public static double [] Pos2;
    public static double [] nextPos;
    public static double[] nextPos1;
    public static double [] nextPos2;


    public int getXmax(){
        return Xmax;
    }
    public static Corps Sun =  Simulation.setAstre("sun", new double[]{300,300},10, new int[]{10, 6});
    public static Corps Moon =  Simulation.setAstre("Moon", new double[]{400, 400},2, new int[]{3, 2});
    public static Corps Earth =  Simulation.setAstre("Earth", new double[]{200,200},4, new int[]{5, 4});

    public static Circle sun = new Circle();
    public static Circle moon = new Circle();
    public static Circle earth = new Circle();

    public int getYmax() {
        return Ymax;
    }

    public void setXmax(int xmax) {
        Xmax = xmax;
    }
    public void setYmax(int ymax){
        Ymax = ymax;
    }

    public int[][] board = new int[Xmax][Ymax];

    public  static void paint() throws InterruptedException {



            Pos = Simulation.getPosition(Sun,Moon,Earth);
            Pos1 = Simulation.getPosition(Moon,Sun,Earth);
            Pos2 = Simulation.getPosition(Earth,Moon,Sun);




            sun.setRadius(50);
            sun.setLayoutX( Pos[0]);
            sun.setLayoutY( Pos[1]);
            sun.setFill(Color.YELLOW);

            earth.setRadius(25);
             earth.setLayoutX( Pos1[0]);
             earth.setLayoutY( Pos1[1]);
            earth.setFill(Color.BLUE);

            moon.setRadius(10);
            moon.setLayoutX( Pos2[0]);
            moon.setLayoutY( Pos2[1]);
            moon.setFill(Color.GRAY);

            Thread.sleep((long) (1/60*Math.pow(10,3)));






    }



    public static void Animation() {


            nextPos = new double[]  { Simulation.getVitesse(Sun, Moon, Earth)[0]+Pos[0],Simulation.getVitesse(Sun, Moon, Earth)[1]+Pos[1]} ;
            nextPos1 = new double[]  { Simulation.getVitesse(Moon,Sun,Earth)[0]+Pos1[0],Simulation.getVitesse(Moon,Sun,Earth)[1]+Pos1[1]} ;
            nextPos2 = new double[]  { Simulation.getVitesse(Earth,Moon,Sun)[0]+Pos2[0],Simulation.getVitesse(Earth,Moon,Sun)[1]+Pos2[1]} ;

            Pos = nextPos;
            Pos1 = nextPos1;
            Pos2 = nextPos2;
    }
}

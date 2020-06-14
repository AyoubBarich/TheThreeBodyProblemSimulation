package com.Ayoub;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public  class Plan   {
    public static double [] Pos = new double[]{450,400};

    public static void Animation()  {
        for (int i = 0; i <Simulation.allBodies.size() ; i++) {
            Simulation.allBodies.get(i).updatePosition(4);
            Simulation.allBodies.get(i).updateVitesse(Simulation.allBodies,4);


        }
    }
    public static void Paint (){
        for (int i = 0; i <Simulation.allBodies.size() ; i++) {
            Corps body = Simulation.allBodies.get(i);
                Simulation.allCircles.get(i).setRadius(body.rayon);
                Simulation.allCircles.get(i).setLayoutX(body.pos[0]);
                Simulation.allCircles.get(i).setLayoutY(body.pos[1]);
                Simulation.allCircles.get(i).setFill(body.color);



        }
    }







}

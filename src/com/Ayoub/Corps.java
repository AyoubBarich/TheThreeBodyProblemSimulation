package com.Ayoub;


import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

public class Corps {
    public String name;
    public double[] pos;
    public int mass;
    public int[] vitesse ;
    public int rayon ;
    public Color color;


    public Corps(String name, double[] position, int mass, int[] vitess, int rayon, javafx.scene.paint.Color color) {
        this.name = name;
        this.pos = position;
        this.mass = mass;
        this.vitesse = vitess;
        this.rayon = rayon;
        this.color = color;
    }


    public void setPos(double[] pos) {
this.pos = pos;

    }

    public double[] getPos() {
        return pos;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getMass() {
        return mass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVitesse(int[] vitesse) {
        this.vitesse = vitesse;
    }

    public int[] getVitesse() {
        return vitesse;
    }


    public  void updateVitesse (ArrayList<Corps> allBodies , float timeStep ){
        for (Corps otherBody : allBodies){
            int i = 0;
            if (otherBody !=this ){
                otherBody.vitesse[0] += Simulation.getAcceleration(otherBody,allBodies.get(i))[0]*timeStep;
                otherBody.vitesse[1] += Simulation.getAcceleration(otherBody,allBodies.get(i))[1]*timeStep;
            }
            i++;
        }
    }
    public  void updatePosition ( float timeStep){

        this.pos[0] += vitesse[0]*timeStep;
        this.pos[1] += vitesse[1]*timeStep;

    }




}










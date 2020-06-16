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
    public java.awt.Color coleur;


    public Corps(String name, double[] position, int mass, int[] vitess, int rayon, javafx.scene.paint.Color color) {
        this.name = name;
        this.pos = position;
        this.mass = mass;
        this.vitesse = vitess;
        this.rayon = rayon;
        this.color = color;
        this.coleur = java.awt.Color.getColor(color.toString()) ;
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
            i++;
            if (otherBody !=this ){
               double sqrDSt = (Math.pow(Math.pow(otherBody.getPos()[0]-allBodies.get(i).getPos()[0],2)+Math.pow(otherBody.getPos()[1]-allBodies.get(i).getPos()[1],2),1.0/2));
               double[] forceDir = new double[]{ ((otherBody.getPos()[0]*otherBody.getPos()[1])/sqrDSt),(allBodies.get(i).getPos()[0]*allBodies.get(i).getPos()[1])/sqrDSt};
               double[] force = new double[]{forceDir[0]*Simulation.G*otherBody.getMass()*allBodies.get(i).getMass()/sqrDSt,forceDir[0]*Simulation.G*otherBody.getMass()*allBodies.get(i).getMass()/sqrDSt};
               double[]  acceleration = new double[]{force[0]*otherBody.getMass(),force[0]*otherBody.getMass()};
               this.vitesse[0] += acceleration[0]*timeStep;
               this.vitesse[1] += acceleration[1]*timeStep;

            }

        }
    }
    public  void updatePosition ( float timeStep){

        this.pos[0] += vitesse[0]*timeStep;
        this.pos[1] += vitesse[1]*timeStep;

    }


    public void draw(Graphics g, double size)
    {
        g.setColor(coleur);
        g.fillOval((int)(650+(pos[0]-rayon/2-650)*size), (int)(500+(pos[0]-rayon/2-500)*size),
                (int)(rayon*size), (int)(rayon*size));
    }
}










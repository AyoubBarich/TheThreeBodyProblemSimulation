package com.Ayoub;



public class Corps {
    public String name;
    public int[] pos;
    public int mass;
    public int[] vitesse;

    public Corps(String name, int[] position, int mass, int[] vitess) {
        this.name = name;
        this.pos = position;
        this.mass = mass;
        this.vitesse = vitess;
    }


    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int[] getPos() {
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

}

package com.Ayoub;

public class Plan {
    public int Xmax;
    public int Ymax;

    public int getXmax(){
        return Xmax;
    }

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
}

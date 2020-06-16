package com.Ayoub;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.ArrayList;





public class Main extends Application {

    public static boolean isRunning = true;
    public  int height=900;
    public Scene scene;
    public int width=800;

    public static void main(String[] args) {
        // write your code here

        Simulation.setAstre("sun", Plan.Pos, 10, new int[]{10, 6}, 50, Color.YELLOW);
        Simulation.setAstre("Moon", Plan.Pos = new double[]{100, 100}, 2, new int[]{3, 2}, 10, Color.GRAY);
        Simulation.setAstre("Earth", Plan.Pos = new double[]{300, 400}, 4, new int[]{5, 4}, 25, Color.BLUE);
        launch(args);


    }


    @Override
    public void start(Stage stage) throws Exception {
    int Time =3;
    final Pane ballContainer = new Pane();


    Plan.Paint();
    //startAnimation(Simulation.allBodies);
    Plan.Animation(Time);
    TransitionHandler();


    scene = new Scene(setRoot(Simulation.allCircles), height, width);



    stage.setTitle("Simulation");
    stage.setScene(scene);
    stage.show();


    }
    public static void TransitionHandler(){


            for (int j = 0; j < Simulation.allBodies.size(); j++) {

                TranslateTransition transition = new TranslateTransition();
                transition.setDuration(Duration.seconds(4));
                transition.setCycleCount(Animation.INDEFINITE);
                //Plan.Animation();
                transition.setToX(Simulation.allBodies.get(j).pos[0]);
                transition.setToY(Simulation.allBodies.get(j).pos[1]);

                System.out.println("X : " + Simulation.allBodies.get(j).pos[0]);
                System.out.println("Y : " + Simulation.allBodies.get(j).pos[1]);
                transition.setNode(Simulation.allCircles.get(j));
                transition.play();


            }

    }
    public Pane setRoot(ArrayList<Circle> bodies){
        Pane root = new Pane();
        root.setStyle("-fx-background-color: #000000;");
        for (Circle body : bodies) {
            root.getChildren().add(body);
        }
        return root;
    }


}

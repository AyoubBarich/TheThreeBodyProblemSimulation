package com.Ayoub;



import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends Application {

    public static void main(String[] args) {
	// write your code here

         Simulation.setAstre("sun", Plan.Pos,10, new int[]{10, 6},50, Color.YELLOW);
          Simulation.setAstre("Moon", Plan.Pos=new double[]{100,100 },2, new int[]{3, 2},10,Color.GRAY);
            Simulation.setAstre("Earth",Plan.Pos=new double[]{300,400 },4, new int[]{5, 4},25,Color.BLUE);
        //System.out.println(Simulation.getForce(Simulation.allBodies.get(1), Simulation.allBodies.get(0))[0]/Simulation.allBodies.get(0).getMass());


        // launch(args);


    }


    @Override
    public void start(Stage stage) throws Exception {
    int Time =3;

    Plan.Paint();
    //Plan.Animation();
    TransitionHandler();


    Scene scene = new Scene(setRoot(Simulation.allCircles), 900, 800);

    stage.setTitle("Simulation");
    stage.setScene(scene);
    stage.show();


    }
    public static void TransitionHandler(){
        for (int i = 0; i <Simulation.allBodies.size() ; i++) {

            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(4));
            transition.setAutoReverse(true);
            transition.setCycleCount(Animation.INDEFINITE);
            transition.setToX(Simulation.allBodies.get(i).pos[0]);
            transition.setToY(Simulation.allBodies.get(i).pos[1]);
            transition.setNode(Simulation.allCircles.get(i));
            transition.play();

        }
    }
    public Pane setRoot(ArrayList<Circle> bodies){
        Pane root = new Pane();
        for (int i = 0; i <bodies.size() ; i++) {
            root.getChildren().add(bodies.get(i));
        }
        return root;
    }
}

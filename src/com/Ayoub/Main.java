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

public class Main extends Application {

    public static void main(String[] args) {
	// write your code here

        launch(args);


    }


    @Override
    public void start(Stage stage) throws Exception {
        int Time =3;
        Pane root =  new Pane();
        Plan.paint();
        Plan.Animation();

    root.getChildren().add(Plan.sun);
    root.getChildren().add(Plan.earth);
    root.getChildren().add(Plan.moon);

    TranslateTransition transitionSun = new TranslateTransition();
    transitionSun.setDuration(Duration.seconds(Time));
    transitionSun.setAutoReverse(true);
    transitionSun.setCycleCount(Animation.INDEFINITE);
    transitionSun.setToX(Plan.nextPos[0]);
    transitionSun.setToY(Plan.nextPos[1]);
    transitionSun.setNode(Plan.sun);
    transitionSun.play();


    TranslateTransition transitionEarth = new TranslateTransition();
    transitionEarth.setDuration(Duration.seconds(Time));

    transitionEarth.setToX(Plan.nextPos1[0]);
    transitionEarth.setAutoReverse(true);
    transitionEarth.setCycleCount(Animation.INDEFINITE);
    transitionEarth.setToY(Plan.nextPos1[1]);
    transitionEarth.setNode(Plan.earth);
    transitionEarth.play();


    TranslateTransition transitionMoon = new TranslateTransition();
    transitionMoon.setDuration(Duration.seconds(Time));
    transitionMoon.setAutoReverse(true);
    transitionMoon.setCycleCount(Animation.INDEFINITE);
    transitionMoon.setToX(Plan.nextPos2[0]);
    transitionMoon.setToY(Plan.nextPos2[1]);
    transitionMoon.setNode(Plan.moon);
    transitionMoon.play();




    Scene scene = new Scene(root, 900, 800);

    stage.setTitle("Simulation");
    stage.setScene(scene);
    stage.show();


    }
}

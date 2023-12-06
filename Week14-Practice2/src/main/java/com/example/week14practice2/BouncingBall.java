package com.example.week14practice2;

// Delta College - CST 183 - Klingler & Anonymous Web Resource
// This application demonstrates simple JavaFX animation tools with a bouncing ball.

// Requirements:

// Done
//Increase the size of the scene to fill the entire screen

// Done: White
//Change the background color of the scene to your choice

// Done: 20
//Double the size of the ball

// Done: Blue
//Change the color of the ball to your choice.


//Increase the speed of the ball.

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BouncingBall extends Application
{
    public static void main(String[] args) { launch(); }

    @Override
    public void start(Stage stage)
    {
        // Set up drawing pane and overall application scene
        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 600, 600, Color.WHITE);



        // Instantiate ball object and set initial position
        Circle ball = new Circle(20, Color.BLUE);
        ball.relocate(5, 5);

        // Add ball object to drawing pane
        canvas.getChildren().add(ball);

        // Set application scene attributes and make visible
        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);

        // Set window full screen
        stage.setMaximized(true);
        stage.show();

        // Instantiate Timeline object as controller for animation.  Each step is called a "keyframe"
        // which is defined by a KeyFrame object.  The keyframe duration (i.e. animation speed) is defined
        // as a parameter (20 milliseconds).
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>()
        {
            // Set "steps" for object in both x and y directions.  Defines change for each iteration
            double xStep = 10;
            double yStep = 10;

            @Override
            public void handle(ActionEvent t)
            {
                // Move the ball object one step for this iteration
                ball.setLayoutX(ball.getLayoutX() + xStep);
                ball.setLayoutY(ball.getLayoutY() + yStep);

                Bounds bounds = canvas.getBoundsInLocal();

                // If the ball reaches the LEFT or RIGHT border, negate the x-step
                // to force the ball to move oppositely
                if(ball.getLayoutX() <= ball.getRadius() ||
                        ball.getLayoutX() >= (canvas.getWidth() - ball.getRadius()))
                {
                    xStep = -xStep;
                }

                // If the ball reaches the BOTTOM or TOP border, negate the y-step
                // to force the ball to move oppositely
                if(ball.getLayoutY() >= (canvas.getHeight() - ball.getRadius()) ||
                        ball.getLayoutY() <= ball.getRadius())
                {
                    yStep = -yStep;
                }
            }
        }));

        // Set number of cycles (infinite) and play simulation.
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


}
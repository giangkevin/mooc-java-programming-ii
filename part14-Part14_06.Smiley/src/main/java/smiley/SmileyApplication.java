package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class SmileyApplication extends Application{
    public void start(Stage window){
        BorderPane paintingLayout = new BorderPane();
        
        Canvas paintingCanvas = new Canvas(450, 450);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        painter.setFill(Color.BLACK);
        
        painter.fillRect(125, 100, 50, 50);
        painter.fillRect(275, 100, 50, 50);
        painter.fillRect(75, 250, 50, 50);
        painter.fillRect(325, 250, 50, 50);
        int number = 0;
        for(int i = 0; i < 4; i++){
            number += 50;
            painter.fillRect(75 + number, 300, 50, 50);
        }
        paintingLayout.setCenter(paintingCanvas);
        
        
        
        Scene view = new Scene(paintingLayout);
        window.setScene(view);
        window.show();
        
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SmileyApplication.class);
    }

}

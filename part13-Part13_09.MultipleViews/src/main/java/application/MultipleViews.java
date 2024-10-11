package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application{
    
    public void start(Stage window){
        BorderPane layout = new BorderPane();
        Label firstView = new Label("First view!");
        Button toSecondView = new Button("To the second view!");
        
        layout.setTop(firstView);
        layout.setCenter(toSecondView);
        Scene first = new Scene(layout);
        
        VBox vBox = new VBox();
        Button toThirdView = new Button("To the third view!");
        Label secondView = new Label("Second view!");
        vBox.getChildren().addAll(toThirdView, secondView);
        
        
        Scene second = new Scene(vBox);
        toSecondView.setOnAction((event) -> {
            window.setScene(second);
        });
        

        
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Third view!"), 0, 0);
        Button toFirstView = new Button("To the first view!");
        gridPane.add(toFirstView, 1, 1);
        
        
        
        Scene third = new Scene(gridPane);
        toThirdView.setOnAction((event) -> {
            window.setScene(third);
        });
        
        toFirstView.setOnAction((event) -> {
            window.setScene(first);
        });
        
        window.setScene(first);
        window.show();
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(MultipleViews.class);
    }

}

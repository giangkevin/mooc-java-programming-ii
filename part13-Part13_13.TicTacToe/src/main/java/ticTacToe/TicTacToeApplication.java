package ticTacToe;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TicTacToeApplication extends Application{
    public void start(Stage stage){
        BorderPane layout = new BorderPane();
        Label turnMessage = new Label("Turn: X");
        turnMessage.setFont(Font.font("Monospaced", 40));
        layout.setTop(turnMessage);
        
        int[][] array = new int [3][3];
        
        GridPane gridPane = new GridPane();
        ArrayList<Button> buttons = new ArrayList<>();
        
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        for (int x = 1; x <= 3; x++){
            for (int y = 1; y <= 3; y++){
                final int row = x - 1;
                final int col = y - 1;
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));
                gridPane.add(btn, x, y);
                
                buttons.add(btn);
                btn.setOnAction((event) -> {
                    if(btn.getText().equals(" ")){
                        if (turnMessage.getText().equals("Turn: X")){
                            btn.setText("X");
                            turnMessage.setText("Turn: O");
                            array[row][col] = 1;
                        }else {
                            btn.setText("O");
                            turnMessage.setText("Turn: X");
                            array[row][col] = -1;
                        }
                    }
                                    
                if (sumOfColumns(array).contains(-3) || sumOfRows(array).contains(-3) || sumOfDiagonals(array).contains(-3)){
                        turnMessage.setText("The end!");
                         disableButtons(buttons);
                    } else if (sumOfRows(array).contains(3) || sumOfColumns(array).contains(3) || sumOfDiagonals(array).contains(3)){
                        turnMessage.setText("The end!");
                         disableButtons(buttons);
                       
                    }
                });
               
            }
            
        }
    
        layout.setCenter(gridPane);
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
        System.out.println("Hello world!");
    }
    
    public static ArrayList<Integer> sumOfRows(int [][] array){
        ArrayList<Integer> sum = new ArrayList<>();
        int total = 0;
        for(int row = 0; row < array.length; row++){
            total = 0;
            for(int col = 0; col < array[row].length; col++){
                total += array[row][col];
                
            }
            sum.add(total);
        }
       return sum;
    }
    
    public static ArrayList<Integer> sumOfColumns(int [][] array){
        ArrayList<Integer> sum = new ArrayList<>();
        int total = 0;
        for(int column = 0; column < array.length; column++){
            total = 0;
            for (int row = 0; row < array[column].length; row++){
                total += array[row][column];
            }
            sum.add(total);
        }
        return sum;
    }
    
    public static ArrayList<Integer> sumOfDiagonals(int [][] array){
        ArrayList<Integer> sum = new ArrayList<>();
        int total = 0;
        for (int i =0; i < array.length; i++){
            total += array[i][i];
        }
        sum.add(total);
        
        total = 0;
        for (int i = 0; i < array.length; i++){
            total += array[i][array.length - 1 -i];
        }
        sum.add(total);
        return sum;
    }
    
    private void disableButtons(ArrayList<Button> buttons) {
    for (Button button : buttons) {
        button.setDisable(true);
    }
}
}

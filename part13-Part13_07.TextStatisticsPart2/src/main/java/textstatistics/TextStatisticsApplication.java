package textstatistics;


import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{

    public void start(Stage window){
        BorderPane layout = new BorderPane();
        HBox hBox = new HBox();
        
        Label letters = new Label("Letters : ");
        Label words = new Label("Words : ");
        Label longestWord = new Label("Longest word : ");
        
        hBox.setSpacing(10);
       
        
        TextArea textArea = new TextArea("");
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int word = parts.length;
            
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            letters.setText("Letters: " + characters);
            words.setText("Words: " + word);
            longestWord.setText("The longest word is: " + longest );
            
        });
        
        hBox.getChildren().addAll(letters, words, longestWord);
        layout.setBottom(hBox);
        layout.setCenter(textArea);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }
    
    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

}

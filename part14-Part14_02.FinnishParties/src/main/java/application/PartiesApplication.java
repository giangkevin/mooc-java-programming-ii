package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        HashMap<String, HashMap<Integer, Double>> values = new HashMap<>();
        try {
            Files.lines(Paths.get("partiesdata.tsv")).forEach(row -> {
                String[] parts = row.split("\t");

                HashMap<Integer, Double> pairYearsValues = new HashMap<>();

                int i = 1;
                for (int years = 1968; years < 2008; years += 4) {
                    if (parts[i].equals("-")) {
                        i++;
                        continue;
                    }
                    pairYearsValues.put(years, Double.valueOf(parts[i]));
                    i++;
                }

                values.put(parts[0], pairYearsValues);
            });

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        values.remove("Party");

        values.keySet().stream().forEach(party -> {

            XYChart.Series data = new XYChart.Series();
            data.setName(party);
            
            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            
           lineChart.getData().add(data);
        });
        
        
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(PartiesApplication.class);
    }

}

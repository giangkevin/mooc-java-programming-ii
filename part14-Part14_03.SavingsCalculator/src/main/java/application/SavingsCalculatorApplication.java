package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public void start(Stage stage) {
        BorderPane layout = new BorderPane();
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");
        lineChart.setAnimated(false);
        lineChart.setLegendVisible(false);

        XYChart.Series monthlySavings = new XYChart.Series<>();
        XYChart.Series interestRate = new XYChart.Series<>();
        lineChart.getData().add(monthlySavings);
        lineChart.getData().add(interestRate);

        layout.setCenter(lineChart);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 20, 20, 20));
        vBox.setSpacing(10);

        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setLeft(new Label("Monthly savings"));
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsLayout.setCenter(monthlySavingsSlider);
        Label numberMonthly = new Label("");
        monthlySavingsLayout.setRight(numberMonthly);

        BorderPane interestRateLayout = new BorderPane();
        interestRateLayout.setLeft(new Label("Yearly interest rate"));
        Slider interestRateSlider = new Slider(0, 10, 0.1);
        interestRateSlider.setShowTickLabels(true);
        interestRateSlider.setShowTickMarks(true);
        interestRateLayout.setCenter(interestRateSlider);
        Label numberInterestRate = new Label("");
        interestRateLayout.setRight(numberInterestRate);

        vBox.getChildren().addAll(monthlySavingsLayout, interestRateLayout);
        layout.setTop(vBox);

        monthlySavingsSlider.setOnMouseReleased((event) -> {
            numberMonthly.setText(Double.toString(monthlySavingsSlider.getValue()));
            updateMonthlySavings(monthlySavingsSlider.getValue(), monthlySavings, interestRateSlider.getValue(), interestRate);
        });

        interestRateSlider.setOnMouseReleased((event) -> {
            numberInterestRate.setText(Double.toString(interestRateSlider.getValue()));
            updateMonthlySavings(monthlySavingsSlider.getValue(), monthlySavings, interestRateSlider.getValue(), interestRate);
        });

        Scene scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private void updateMonthlySavings(double monthlyAmount, XYChart.Series monthlySavings, double interestRateValue, XYChart.Series interestRate) {
        monthlySavings.getData().clear();
        interestRate.getData().clear();
        monthlySavings.getData().add(new XYChart.Data(0, 0));
        interestRate.getData().add(new XYChart.Data(0, 0));
        
        double savingsWithInterest = 0;
        for (int i = 1; i < 30; i++) {

            monthlySavings.getData().add(new XYChart.Data(i, i * monthlyAmount * 12));

            savingsWithInterest += monthlyAmount * 12;
            savingsWithInterest += savingsWithInterest * (interestRateValue / 100.0);

            interestRate.getData().add(new XYChart.Data(i, savingsWithInterest));
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(SavingsCalculatorApplication.class);
    }

}

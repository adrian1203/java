package lab7.wykres;

import javafx.event.ActionEvent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class Controller {
    public Button test;
    public LineChart wykres;
    public Button button;

    public void metoda(ActionEvent actionEvent) {
    }

    public void button(ActionEvent actionEvent) {
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        wykres.getData().add(series);
    }
}

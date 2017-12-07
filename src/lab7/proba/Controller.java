package lab7.proba;

import javafx.event.ActionEvent;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {
    public TextField prob;
    public TextField down;
    public TextField top;
    public TextField a;
    public TextField b;
    public TextField c;
    public Button buttn;
    public Pane panel2;
    public LineChart chart;


    public void displaychart(ActionEvent actionEvent) {
        chart.setCreateSymbols(false);
       int probvar =Integer.parseInt(prob.getText());
        int topvar =Integer.parseInt(top.getText());
        int downbvar =Integer.parseInt(down.getText());
        double avar =Double.parseDouble(a.getText());
        double bvar =Double.parseDouble(b.getText());
        double cvar =Double.parseDouble(c.getText());
        XYChart.Series series = new XYChart.Series();
        for(int i=downbvar; i< topvar; i+=probvar){
            series.getData().add(new XYChart.Data(i,cvar+i*bvar+avar*Math.pow(i,2)));
        }
        NumberAxis xAxis = new NumberAxis();
        CategoryAxis yAxis = new CategoryAxis();
        chart=new  LineChart(xAxis, yAxis);
        chart.getData().add(series);

        panel2.setVisible(true);



    }
}

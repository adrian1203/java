package lab7.GUI;

import io.indico.api.utils.IndicoException;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import kolos.comarator.lista;
import lab6.api.*;
import javafx.event.ActionEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Controller {
    public ListView<String> list;
    public Api api = new Api();
    public File selectedDriectory;
    public File selectedDriectory2;
    public ImageView imageView;
    public PieChart pieChart;

    public void directory_choose(ActionEvent actionEvent) throws Myerr, IOException, IndicoException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        selectedDriectory = directoryChooser.showDialog(new Stage());
        if (selectedDriectory.isDirectory()) {
            DisplayList();
        }
    }

    public void DisplayList() {
        String[] filelist = selectedDriectory.list();
        List<String> pictures = new LinkedList<>();
        for (int i = 0; i < filelist.length; i++) {
            if (filelist[i].trim().contains(".jpg"))
                pictures.add(filelist[i]);
        }
        ObservableList<String> itms = FXCollections.observableArrayList(pictures);
        list.setItems(itms);
    }


    public void showPicture(MouseEvent mouseEvent) throws IOException, IndicoException {
        String photoname = list.getFocusModel().getFocusedItem().toString();
        String photopath = selectedDriectory.getAbsolutePath().toString() + "\\" + photoname;
        File file = new File(photopath);
        InputStream fis = new FileInputStream(file);
        Image image = new Image(fis);
        imageView.setImage(image);
        showChart(photopath);

    }

    public void showChart(String photopath) throws IOException, IndicoException {
        pieChart.setData(api.pieChartDate(api.Probability(photopath)));
        pieChart.setClockwise(true);
        pieChart.setTitle("Wykres przynależności do klas ");
    }

    public void segregate(ActionEvent actionEvent) throws Myerr, IOException, IndicoException {
        DirectoryChooser directoryChooser2 = new DirectoryChooser();
        selectedDriectory2 = directoryChooser2.showDialog(new Stage());
        String selctedirectorypath=selectedDriectory2.getPath();
        System.out.println(selctedirectorypath);
        api.Segregate(selctedirectorypath);

    }
}

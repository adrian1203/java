package lab6.api;

import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.awt.desktop.FilesEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Api {
    public void Segregate(String filepath) throws IOException, IndicoException , Myerr{

        File file = new File(filepath);

        Indico indico = new Indico("958b1c047617007808f8fbafa9467184");
        String[] lista = file.list();
        for (String x : lista) {
            System.out.println(x);
        }
        List<String> pictures = new LinkedList<>();
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].trim().contains(".jpg"))
                pictures.add(file.getPath() + "\\" + lista[i]);

        }
        file.setExecutable(true);
        File newfile;
        for (String x : pictures) {
            System.out.println(x);
        }


        for (String photo : pictures) {

            IndicoResult single = indico.imageRecognition.predict(photo);
            Map<String, Double> result = single.getImageRecognition();
            double max=0;
            StringBuilder bulder = new StringBuilder();
            List<String> listofkeys = new LinkedList<>();
            String filename = "";
            for (String key : result.keySet()) {
                System.out.println(result.get(key));
                if (Math.max(result.get(key), max) > max) {
                    max = Math.max(result.get(key), max);
                    bulder.delete(0, bulder.length());
                }
                if (max==result.get(key)) bulder.append(key);
            }
            filename = bulder.toString();
            newfile = new File(file.getPath() + "\\" + filename);
            if (!newfile.isDirectory()) newfile.mkdir();
            File image = new File(photo);
            Files.move(Paths.get(image.getPath()), Paths.get(newfile.getPath() + "\\" + image.getName()), StandardCopyOption.ATOMIC_MOVE);

        }
    }
    public Map<String, Double> Probability(String filepath) throws IndicoException, IOException {
        Indico indico = new Indico("958b1c047617007808f8fbafa9467184");
        IndicoResult single = indico.imageRecognition.predict(filepath);
        Map<String, Double> result = single.getImageRecognition();
        return result;
    }
    public ObservableList<PieChart.Data> pieChartDate (Map<String, Double> mapa){
        ObservableList<PieChart.Data> pieChartDate = FXCollections.observableArrayList();
        for (String key : mapa.keySet()) {
            if (mapa.get(key) > 0.03) {
                pieChartDate.add(new PieChart.Data(key, mapa.get(key)));
            }

        }
        return pieChartDate;
    }
}

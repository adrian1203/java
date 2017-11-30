package lab8.bazadanych;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("viev.fxml"));
        primaryStage.setTitle("Obsługa bazy danych");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();
    }
}

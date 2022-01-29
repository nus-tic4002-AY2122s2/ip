package edu.nus.duke;

import java.io.IOException;

import edu.nus.duke.view.MainWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private Duke duke = new Duke("data/duke.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            VBox vBox = fxmlLoader.load();
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            fxmlLoader.<MainWindow>getController().initDukeFeedback();
            fxmlLoader.<MainWindow>getController().setAutoScrollPane();
            Scene scene = new Scene(vBox);
            stage.setScene(scene);
            stage.setTitle("Duke");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

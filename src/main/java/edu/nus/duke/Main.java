package edu.nus.duke;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            VBox vBox = fxmlLoader.load();
            ScrollPane scrollPane = (ScrollPane) vBox.getChildren().get(0);
            VBox dialogContainer = (VBox) scrollPane.getContent();
            dialogContainer.heightProperty().addListener((observable -> scrollPane.setVvalue(1.0)));
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

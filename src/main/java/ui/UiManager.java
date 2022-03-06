package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import taskExecutor.TaskExecutor;
import ui.controller.MainWindow;

import java.io.IOException;
import java.net.URL;

public class UiManager {
    private Scene scene;
    private final FXMLLoader fxmlLoader;

    public UiManager() {
        URL fileLocation = getClass().getResource("/view/MainWindow.fxml");
        fxmlLoader = new FXMLLoader(fileLocation);
        AnchorPane ap = null;
        try {
            ap = fxmlLoader.load();
            scene = new Scene(ap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(Stage stage, TaskExecutor taskExecutor) {
        stage.setScene(scene);
        fxmlLoader.<MainWindow>getController().setTaskExecutor(taskExecutor);
        stage.show();
    }
}

package ip.duke.gui;

import static ip.duke.Duke.DATA_PATH;

import java.io.IOException;

import ip.duke.Duke;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private final Duke duke = new Duke(DATA_PATH);


    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            stage.setResizable(false);
            stage.show();
            stage.setTitle("LisGenie");
            stage.getIcons().add(new Image("/images/DaDuke.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

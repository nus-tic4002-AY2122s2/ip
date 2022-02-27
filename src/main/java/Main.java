import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {
    String filename = "data/dukeTaskOuput.txt";
    private Duke duke = new Duke(filename);

    @Override
    public void start(Stage stage) {
        try {
            URL res = Main.class.getResource("/view/MainWindow.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(res);
            AnchorPane ppp = fxmlLoader.load();
            Scene scene = new Scene(ppp);
            stage.setResizable(false);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke, stage);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
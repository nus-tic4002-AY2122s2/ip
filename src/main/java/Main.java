import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import application.ErrorController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {
    String filename = "data/dukeTaskOuput.txt";
    private Duke duke = new Duke(filename);

    @Override
    public void start(Stage stage) throws Exception{
        try {

            Thread.setDefaultUncaughtExceptionHandler(Main::showError);
            URL res = Main.class.getResource("/view/MainWindow.fxml");
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
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

    public static void showErrorPopup(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
    }


    private static void showError(Thread t, Throwable e) {
        System.err.println("***Default exception handler***");
        if (Platform.isFxApplicationThread()) {
            showErrorDialog(e);
        } else {
            System.err.println("An unexpected error occurred in "+t);

        }
    }

    private static void showErrorDialog(Throwable e) {
        StringWriter errorMsg = new StringWriter();
        e.printStackTrace(new PrintWriter(errorMsg));
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("Error.fxml"));
        try {
            Parent root = loader.load();
            ((ErrorController)loader.getController()).setErrorText(errorMsg.toString());
            dialog.setScene(new Scene(root, 250, 400));
            dialog.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
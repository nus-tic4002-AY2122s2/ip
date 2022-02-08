package duke.ui;


import duke.Duke;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import java.io.IOException;
import java.util.Collections;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class TestView extends UiPart<Region> {

    private static final String FXML = "TestView.fxml";



    @FXML
    private HBox testPane;
    @FXML
    private Label testLbl;

    private static Image userImage = new Image(Duke.class.getResourceAsStream("/images/DaUser.png"));
    private static Image dukeImage = new Image(Duke.class.getResourceAsStream("/images/DaDuke.png"));


    public TestView(String text) {
        super(FXML);
        testLbl.setText(text);
    }


//    public static TestView getUserDialog(String text) {
//        return new TestView(text);
//    }
//
//    public static TestView getDukeDialog(String text) {
//        var db = new TestView(text);
//        return db;
//    }

}

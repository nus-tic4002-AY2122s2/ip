package duke.ui;

import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends UiPart<Region> {

    private static final String FXML = "DialogBox.fxml";

    @FXML
    private Text dialog;
    @FXML
    private Circle displayPicture;
    @FXML
    private HBox dialogBoxPane;
    @FXML
    private TextFlow textFlow;


    private DialogBox(String text, Image img, boolean isUser) {
        super(FXML);
        dialog.setText(text);
        displayPicture.setFill(new ImagePattern(img));
        textFlow.setStyle(isUser ? "-fx-background-color: #cde6c8" : "-fx-background-color: #ffffff");
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(dialogBoxPane.getChildren());
        Collections.reverse(tmp);
        dialogBoxPane.getChildren().setAll(tmp);
        dialogBoxPane.setAlignment(Pos.TOP_LEFT);
    }

    public static DialogBox getUserDialog(String text, Image img) {
        return new DialogBox(text, img, true);
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img, false);
        db.flip();
        return db;
    }

}

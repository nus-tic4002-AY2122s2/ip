package duke.ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class ChatBubble extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private Label profile;
    @FXML
    private Circle pbg;
    @FXML
    private Rectangle bbg;
    @FXML
    private StackPane bubble;
    @FXML
    private StackPane head;


    private ChatBubble(String emoji, String text) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/ChatBubble.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        profile.setText(emoji);
        dialog.setText(text);

        bbg.widthProperty().bind(dialog.widthProperty());
        bbg.heightProperty().bind(dialog.heightProperty());
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
    }

    private void setPbgColor(String hex) {
        this.pbg.setFill(Color.web(hex));
    }

    private void setBbgColor(String hex) {
        this.bbg.setFill(Color.web(hex));
    }

    private void setBubbleAlignment(Pos pos) {
        this.bubble.setAlignment(pos);
    }

    public static ChatBubble getUserDialog(String emoji, String input) {
        var chatBubble = new ChatBubble(emoji, input);

        return chatBubble;
    }

    public static ChatBubble getDukeDialog(String emoji, String reply) {
        var chatBubble = new ChatBubble(emoji, reply);
        chatBubble.setPbgColor("f5ecb3");
        chatBubble.setBbgColor("D0D7D9");
        chatBubble.flip();
        chatBubble.setBubbleAlignment(Pos.TOP_LEFT);
        return chatBubble;
    }
}

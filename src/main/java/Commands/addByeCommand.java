package Commands;
import Ui.*;
import Storage.*;
import TaskList.*;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.util.Duration;

public class addByeCommand extends Command{

    public static final String COMMAND = "bye";

    public addByeCommand(boolean exit){
        super(false);
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws InterruptedException {
        ui.showGoodBye();
        PauseTransition delay = new PauseTransition(Duration.seconds(999999999));
        delay.play();
        Platform.exit();
        return "";
    }
}
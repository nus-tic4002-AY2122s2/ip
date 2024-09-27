package Commands;
import Ui.*;
import Storage.*;
import TaskList.*;

public class invalidCommand extends Command{

//    public static final String COMMAND = "bye";
    public String userInput;
    public invalidCommand(String userInput){
        this.userInput = "\t☹ OOPS!!! I'm Sorry, Please Key in a valid Command :-(";
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage){
        return userInput;
    }
}
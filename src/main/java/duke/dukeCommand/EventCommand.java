package duke.dukeCommand;
import duke.dukeUI.*;
import duke.dukeTaskList.*;
import duke.dukeStorage.*;
import duke.dukeException.*;
import duke.dukeUI.*;
import duke.dukeTask.*;
import java.io.IOException;

public class EventCommand extends Command{

    private EventCommand event;

    public EventCommand(String userInput){
        super(userInput);
    }

    @Override
    public void execute(DukeTaskList taskList, DukeUI ui, DukeStorage storage) throws DukeException, IOException{
        try{
            String[] userInput = null;
            userInput = input.split(" ",2);
            if(userInput[1].trim() != ""){
                String description = userInput[1].trim().substring(0, userInput[1].trim().indexOf("/at") - 1);
                String date = userInput[1].trim().substring(userInput[1].trim().indexOf("/at") + 4, userInput[1].trim().length());
                DukeStorage.saveFunction(new Event(description, date));
                DukeStorage.saveToFile("E",description,date);
            }
        }catch(IndexOutOfBoundsException e){
             throw new DukeException("☹ OOPS!!! Please check event command that you have key in is in correct format.");
        }catch(IOException e1){
            e1.printStackTrace();
        }
    }
}
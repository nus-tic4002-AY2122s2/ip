package duke.dukeParser;

import duke.dukeCommand.*;
import java.io.IOException;
import duke.dukeException.*;

public class DukeParser{
    public static Command parseInput(String userInput) throws DukeException{
        String input = userInput;
        switch(input.split(" ")[0]){
            case "deadline":
                return new DeadlineCommand(input);
            case "event":
                return new EventCommand(input);
            case "todo":
                return new TodoCommand(input);
            case "list":
                return new ListCommand("");
            case "delete":
                return new DeleteCommand(input);
            case "done":
                return new DoneCommand(input);
            case "bye":
                return new ByeCommand("");
            default:
                throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
    }
}
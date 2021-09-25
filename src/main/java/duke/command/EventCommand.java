package duke.command;

import duke.storage.Storage;
import duke.ui.Ui;
import duke.task.TaskList;
import duke.dukeException.DukeException;
import duke.task.Event;
import duke.task.TaskType;
import duke.parser.Parser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class EventCommand extends Command{

    /**
     * Constructs the Event Command
     * @param taskDes the Command the User input
     */
    public EventCommand(String taskDes){
        super(taskDes);
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try{
            commandInstruction.substring(6);
        }
        catch(StringIndexOutOfBoundsException e){
            throw new DukeException("Event command can't be empty");
        }
        if(!commandInstruction.contains(" /at ")){
            throw new DukeException("Please state /at yyyy-mm-dd");
        }
        int dividerPosition2 = commandInstruction.indexOf(" /at ");
        String taskDes = commandInstruction.substring(6, dividerPosition2);
        String taskDateTime = commandInstruction.substring(dividerPosition2+5);
        Event event = new Event(taskDes, taskDateTime);
        tasks.addTask(event);
        storage.save(tasks);
    }

    /**
     * Checking if the user has input any time and adding it into the class if he has
     * @param taskDes the task description
     * @param taskDateTime the task date and time
     * @return the events class
     * @throws DukeException any expected error
     */
    public static Event eventTimeSetter(String taskDes, String taskDateTime) throws DukeException {
        try{
            if (!taskDateTime.contains(" ")) {
                LocalDate d1 = Parser.convertStringToDate(taskDateTime);
                return new Event(taskDes, d1);
            } else {
                int dividerPosition3 = taskDateTime.indexOf(" ");
                String taskDate = taskDateTime.split(" ")[0];
                String taskTime = taskDateTime.substring(dividerPosition3 + 1);
                LocalDate d1 = Parser.convertStringToDate(taskDate);
                LocalTime t1 = Parser.convertStringToTime(taskTime);
                return new Event(taskDes, d1, t1);

            }
        }catch (DateTimeParseException e){
            throw new DukeException("Please set date as YYYY-MM-DD");
        }
    }


}

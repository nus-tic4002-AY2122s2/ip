package commands;

import java.util.Vector;

import exceptions.DukeDateTimeError;
import exceptions.DukeTaskInputException;
import parser.Parser;
import storage.Storage;
import taskclasses.Deadline;
import taskclasses.Event;
import taskclasses.Task;
import taskclasses.TaskList;
import taskclasses.Todo;
import ui.Ui;

public class AddCommand extends Command {

    private String type;
    private String[] inputWords;
    private String description;

    /**
     * The method to initialize AddCommand
     *
     * @param type the task type
     * @param inputWords the entire input in String[] type
     * @throws DukeTaskInputException handle all the errors during user input
     */
    public AddCommand(String type, String[] inputWords) throws DukeTaskInputException {
        this.type = type;
        this.inputWords = inputWords;
        this.description = Parser.toExtractDescription(inputWords);
    }

    /**
     * To add Todo type task to the task list
     * The output (message print onto screen) will be included in this method
     *
     * @param list the entire task list
     */
    private String addTodoTask(Vector<Task> list) {

        Todo inputTask = new Todo (description);
        list.add(inputTask);

        String echoInfo = Ui.printTodoAddedOutput(inputTask, list.size());

        return echoInfo;
    }

    /**
     * To add Deadline type task to the task list
     * The output (message print onto screen) will be included in this method after task added
     *
     * @param list the entire task list
     */
    private String addDeadlineTask (Vector<Task> list) throws DukeTaskInputException, DukeDateTimeError {
        String date = Parser.toExtractDate(inputWords);

        Deadline newTask = new Deadline(description, false, date);

        list.add(newTask);

        return Ui.printDeadlineAddedOutput(newTask, list.size());
    }

    /**
     * To add Event type task to the task list
     * The output (message print onto screen) will be included in this method after task added
     *
     * @param list the entire task list
     */
    private String addEventTask (Vector<Task> list) throws DukeTaskInputException, DukeDateTimeError {

        String date = Parser.toExtractDate(inputWords);
        String startingDateTime = Parser.extractStartingDateTime(date);
        String endingDateTime = Parser.extractEndingDateTime(date);


        Event newTask = new Event(description, false, startingDateTime, endingDateTime);

        list.add(newTask);

        return Ui.printEventAddedOutput(newTask, list.size());
    }

    /**
     * The method to execute command
     *
     * @param taskList contain all the task
     * @param ui Ui class
     * @param storage Storage class
     * @throws DukeTaskInputException throw all errors about input command
     * @throws DukeDateTimeError throw all errors about date and time
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException, DukeDateTimeError {
        Vector<Task> list = taskList.getVectorList();
        String echoInfo = "";

        switch (type) {
        case "todo":
            echoInfo = addTodoTask(list);
            break;
        case "deadline":
            echoInfo = addDeadlineTask(list);
            break;
        case "event":
            echoInfo = addEventTask(list);
            break;
        default:
            break;
        }

        //return "Add Command";
        return echoInfo;
    }

    /**
     * The method to let system know whether the command is to exit the Duke
     * @return return false, the program continue
     */
    @Override
    public boolean isExit() {
        return false;
    }
}

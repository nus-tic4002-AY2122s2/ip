package commands;


import exceptions.DukeTaskInputException;
import storage.Storage;
import task_classes.*;
import ui.Output_On_Screen;
import parser.Parser;
import ui.Ui;

import java.util.Vector;

public class AddCommand extends Command{

    private String type;
    private String[] inputWords;
    private String description;

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
    private void addTodoTask(Vector<Task> list){

        Todo inputTask = new Todo (description);
        list.add(inputTask);

        Output_On_Screen.printTodoAddedOutput(inputTask, list.size());
    }

    /**
     * To add Deadline type task to the task list
     * The output (message print onto screen) will be included in this method after task added
     *
     * @param list the entire task list
     */
    private void addDeadlineTask (Vector<Task> list) throws DukeTaskInputException {

        String date = Parser.toExtractDate(inputWords);

        Deadline newTask = new Deadline(description, date);

        list.add(newTask);

        Ui.printDeadlineAddedOutput(newTask, list.size());
    }

    /**
     * To add Event type task to the task list
     * The output (message print onto screen) will be included in this method after task added
     *
     * @param list the entire task list
     */
    private void addEventTask (Vector<Task> list) throws DukeTaskInputException {

        String date = Parser.toExtractDate(inputWords);

        Event newTask = new Event(description, date);

        list.add(newTask);

        Ui.printEventAddedOutput(newTask, list.size());
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeTaskInputException {
        Vector<Task> list = taskList.getVectorList();

        switch (type) {
            case "todo":
                addTodoTask(list);
                break;
            case "deadline":
                addDeadlineTask(list);
                break;
            case "event":
                addEventTask(list);
                break;
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

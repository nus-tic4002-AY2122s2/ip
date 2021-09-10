package command;

import exception.EmptyException;
import basic.TaskList;
import basic.Ui;
import task.Event;

/**
 * Adds an event task to the task list.
 */
public class AddEventCommand extends Command {
    private String input;

    /**
     * @param input A String inputted by the user.
     */
    public AddEventCommand(String input) {
        this.input = input;
    }

    /**
     * @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @throws EmptyException If an empty description is inputted.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) throws EmptyException {
        int position;
        input = input.toLowerCase();

        if (input.contains("event")){
            input = input.replace("event", "");
        }
        else{
            input = input.replaceFirst("e", "");
        }
        if (input.contains("/at")) {
            position = input.indexOf("/at");
        }
        else {
            position = -1;
        }

        if (position != -1 && (!input.substring(0, position - 1).equals("") || !input.substring(0, position - 2).equals(" "))) {
            String date = input.substring(position + 4);
            input = input.substring(0, position - 1);
            Event event = new Event(input, date);
            tasks.addTask(event);
            ui.showAdded();
            ui.printTaskNum(tasks, event);
        }
        else {
            throw new EmptyException("an event");
        }
    }

}



package command;

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
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        input = input.toLowerCase();
        if (input.contains("event")){
            input = input.replace("event", "");
        }
        else{
            input = input.replaceFirst("e", "");
        }
        int position = input.indexOf("/at");

        if (!input.substring(0, position - 1).equals("") || !input.substring(0, position - 2).equals(" ")) {
            String date = input.substring(position + 4);
            input = input.substring(0, position - 1);
            Event event = new Event(input, date);
            tasks.addTask(event);
            ui.showAdded();
            ui.printTaskNum(tasks, event);
        }
    }

}



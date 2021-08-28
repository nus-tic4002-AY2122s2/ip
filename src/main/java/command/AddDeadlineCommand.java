package command;

import basic.TaskList;
import basic.Ui;
import task.Deadline;

/**
 * Adds a deadline task to the task list.
 */
public class AddDeadlineCommand extends Command {

    private String input;

    /**
     * @param input A String inputted by the user.
     */
    public AddDeadlineCommand(String input) {
        this.input = input;
    }

    /**
     * @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     */
    @Override
    public void execute(TaskList tasks, Ui ui) {
        input = input.toLowerCase();
        if (input.contains("deadline")) {
            input = input.replace("deadline", "");
        }
        else{
            input = input.replaceFirst("d", "");
        }
        int position = input.indexOf("/by");
        if (!input.substring(0, position - 1).equals("") && !input.substring(0, position - 1).equals(" ")) {
            String date = input.substring(position + 4);
            input = input.substring(0, position - 1);
            Deadline deadline = new Deadline(input, date);
            tasks.addTask(deadline);
            ui.showAdded();
            ui.printTaskNum(tasks, deadline);
        }
    }

}

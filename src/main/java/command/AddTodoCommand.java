package command;

import exception.EmptyException;
import basic.TaskList;
import basic.Ui;
import task.Todo;

/**
 * Adds a todo task to the task list.
 */
public class AddTodoCommand extends Command {
    protected static Ui ui = new Ui();
    private String input;

    /**
     * @param input A String inputted by the user.
     */
    public AddTodoCommand(String input) {
        this.input = input;
    }

    /**
     * @param tasks   The tasks stored in an ArrayList.
     * @param ui      The User Interface (UI).
     * @throws EmptyException If an empty description is inputted.
     */
    @Override
    public void execute(TaskList tasks, Ui ui) throws EmptyException  {
        input = input.toLowerCase();
        if (input.contains("todo")){
            input = input.replace("todo", "");
        }
        if (!input.equals("") && !input.equals(" ")) {
            Todo todo = new Todo(input);
            tasks.addTask(todo);
            ui.showAdded();
            ui.printTaskNum(tasks, todo);
        }
        else {
            throw new EmptyException("a todo");
        }
    }

}
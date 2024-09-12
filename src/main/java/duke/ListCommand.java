package duke;

/*
 *  ListCommand.java
 *  Defines the 'List' action flow to list tasks.
 */
public class ListCommand extends Command {
    /**
     *  Constructs List Command object.
     */
    public ListCommand(){

    }

    /*
     * This method 'Executes' the command and
     *  display all tasks in the task list.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        StringBuilder output = new StringBuilder("\tHere are the tasks in your list:" + "\n");
        //print all tasks in task list
        for (int i = 1; i < tasks.getTaskSize() + 1; i++) {
            Task task = TaskList.getTaskList().get(i - 1);
            output.append("\t").append(String.format(i + "." + task, task.getStatusIcon())).append("\n");
        }
        return output.toString();
    }

    /*
     * Returns not to exit program.
     * @return false Command 'duke' not to exit
     * after list command.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}

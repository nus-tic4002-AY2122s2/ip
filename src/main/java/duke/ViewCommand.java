package duke;

/*
 *  ViewCommand.java
 *  Defines the 'View' action to view
 *  schedule for a specific date.
 */
public class ViewCommand extends Command {
    private String keyWord;

    /*
     *  Constructs View Command object.
     */

    public ViewCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    /*
     * This method 'Executes' the command and
     *  display searched tasks in the task list.
     * @param tasks Object of Task class.
     * @param storage Object of Storage class.
     */
    @Override
    public String execute(TaskList tasks, Storage storage) {
        StringBuilder output = new StringBuilder("\tHere are the tasks matching your schedule:\n");
        //print all tasks in task list
        for (int i = 1; i < tasks.getTaskSize() + 1; i++) {
            Task task = TaskList.getTaskList().get(i - 1);
            String dateTime = "";
            if (task.getTaskType() == 'E') {
                Event event;
                event = (Event) TaskList.getTaskList().get(i - 1);
                dateTime = event.getLast();
            }
            if (task.getTaskType() == 'D') {
                Deadline deadline;
                deadline = (Deadline) TaskList.getTaskList().get(i - 1);
                dateTime = deadline.getLast();
            }
            if (dateTime.contains(keyWord)) {
                output.append("\t").append(String.format(i + "." + task, task.getStatusIcon())).append("\n");
            }
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

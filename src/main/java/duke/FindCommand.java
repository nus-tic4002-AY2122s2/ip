package duke;

/*  Recommit to correct naming.
 *  FindCommand.java
 *  Defines the 'Find' action to search tasks using keywords.
 */
public class FindCommand extends Command {
    private String keyWord;
    /**
     *  Constructs Find Command object.
     */

    FindCommand(String keyWord) {
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
        StringBuilder output = new StringBuilder("\tHere are the matching tasks in your list:\n");
        //print all tasks in task list
        for (int i = 1; i < tasks.getTaskSize() + 1; i++) {
            Task task = TaskList.getTaskList().get(i - 1);
            String description = task.getDescription();
            if (description.contains(keyWord)) {
                output.append("\t").append(String.format(i + "." + task, task.getStatusIcon() + "\n"));
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

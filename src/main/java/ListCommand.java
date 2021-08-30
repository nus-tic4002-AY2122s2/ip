public class ListCommand extends Command {
    public ListCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(TaskList taskList) {
        UI.listMessage(taskList.tasks);
    }
}

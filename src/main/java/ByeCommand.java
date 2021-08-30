public class ByeCommand extends Command {
    public ByeCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(TaskList taskList) {
        UI.byeMessage();
    }
}

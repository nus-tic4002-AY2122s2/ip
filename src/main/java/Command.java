public class Command {
    protected String fullCommand;
    protected boolean isExit;

    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    public void execute(TaskList taskList) {
        String command = fullCommand;

        switch (command) {
            case "list":
                UI.listMessage(taskList.taskList);
                break;
            case "bye":
                UI.byeMessage();
                isExit = true;
                break;
            default:
                taskList.addTaskCommand(fullCommand);
                break;
        }
    }
}

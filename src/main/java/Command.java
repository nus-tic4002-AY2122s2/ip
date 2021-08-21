public class Command {
    protected String fullCommand;
    protected boolean isExit;

    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
        this.isExit = false;
    }

    public void execute() {
        String command = fullCommand;

        switch (command) {
            case "bye":
                UI.byeMessage();
                isExit = true;
                break;
            default:
                UI.echoMessage(command);
                isExit = false;
                break;
        }
    }
}

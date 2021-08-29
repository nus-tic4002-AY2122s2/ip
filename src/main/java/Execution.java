public class Execution {
    protected String fullCommand;
    protected String command;
    protected boolean isExit;

    public Execution(String fullCommand) {
        this.fullCommand = fullCommand;
        this.command = Parser.command(fullCommand);
        this.isExit = false;
    }

    private static void CheckFirstWord(String command) throws CommandException {
        if ( !(command.equals("todo" ) || command.equals( "deadline") || command.equals( "event")
                || command.equals( "bye") || command.equals( "list") || command.equals( "done")) ) {
            throw new CommandException();
        }
    }
    private static void CheckElement(String fullCommand) throws LackOfElementException {
        if (  fullCommand.equals("todo") || fullCommand.equals("deadline") || fullCommand.equals("event")
                || fullCommand.equals("done") ) {
            throw new LackOfElementException();
        }
    }

    public void execute(TaskList taskList) {
        try {
            CheckFirstWord(command);
        } catch (CommandException e) {
            System.out.println("OOPS!!! Pls key in the valid command");
        }

        switch (command) {
            case "list":
                UI.listMessage(taskList.tasks);
                break;
            case "done":
                try {
                    CheckElement(fullCommand);
                    taskList.doneCommand(fullCommand);
                } catch (LackOfElementException e) {
                    System.out.println("OOPS!!! Pls key in the number of the task");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("OOPS!!! The number of task is invalid! Please key in again!");
                }
                break;
            case "bye":
                UI.byeMessage();
                isExit = true;
                break;
            case "todo":
                try {
                    CheckElement(fullCommand);
                    taskList.addTodoCommand(fullCommand);
                } catch (LackOfElementException e) {
                    System.out.println("OOPS!!! Pls key in the description for the task");
                }
                break;
            case "deadline":
                try {
                    CheckElement(fullCommand);
                    taskList.addDeadlineCommand(fullCommand);
                } catch (LackOfElementException e) {
                    System.out.println("OOPS!!! Pls key in the description for the task");
                }
                break;
            case "event":
                try {
                    CheckElement(fullCommand);
                    taskList.addEventCommand(fullCommand);
                } catch (LackOfElementException e) {
                    System.out.println("OOPS!!! Pls key in the description for the task");
                }
                break;
        }
    }
}

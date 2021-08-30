public class AddTodoCommand extends Command {
    public AddTodoCommand(String fullCommand) {
        super(fullCommand);
    }

    private static void CheckDescription(String fullCommand) throws LackOfDescriptionException {
        if (fullCommand.trim().equals("todo") ) {
            throw new LackOfDescriptionException();
        }
    }

    public void run(TaskList taskList) {
        try {
            CheckDescription(fullCommand);
            String description = Parser.description(fullCommand);
            taskList.addTodo(description);
            int size = taskList.size;
            UI.addMessage(taskList.tasks.get(size - 1), size);
        } catch (LackOfDescriptionException e) {
            System.out.println("OOPS!!! Pls key in the description for the task");
        }
    }
}

package taskExecutor;

import command.Command;
import exception.ErrorHandler;
import parser.CommandParser;
import parser.DataParser;
import storage.Storage;
import taskList.TaskList;


public class TaskExecutor {
    private final Storage storage;
    private final TaskList tasks;
    private ExecutionResult executionResult = new ExecutionResult();


    public TaskExecutor() {
        this.storage = new Storage("data/tasks.txt");
        this.tasks = new TaskList();
        this.loadTasks();
    }

    public void execute(String userInput) {
        try {
            Command command = new CommandParser().parse(userInput);
            command.execute(this.storage, this.tasks);
            executionResult = command.getExecutionResult();
        } catch (Exception e) {
            executionResult.setError("Error: " + e.getMessage());
        }
    }

    public String getErrorMessage() {
        return this.executionResult.getError();
    }

    public String getSystemMessage() {
        return this.executionResult.getSystemMessage();
    }

    public String[] getResult() {
        return this.executionResult.getResult();
    }

    private void loadTasks() {
        try {
            String[] data = this.storage.loadData();

            for (String line : data) {
                Command command = new DataParser().parse(line);
                command.execute(this.storage, this.tasks);
            }
        } catch (ErrorHandler e) {
            System.out.println(e.getMessage());
        }
    }

}

package duke;

import duke.task.Task;

import java.util.ArrayList;

public class Duke {
    private TaskList taskList;
    private String filePath;

    /**
     * Create new Duke with new task list and filepath for loading and saving data.
     * */
    public Duke() {
        ArrayList<Task> tasks = new ArrayList<>();
        this.taskList = new TaskList(tasks);
        this.filePath = "data/duke.txt";
    }

    private void run() {
        Storage storage = new Storage(filePath);
        storage.loadFile(taskList);
        UI.welcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = UI.readCommand();
                Execution execution = new Execution(fullCommand);
                UI.splitLine();
                execution.execute(taskList);
                storage.saveFile(taskList);
                isExit = execution.isExit;
            } catch (Exception e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } finally {
                UI.splitLine();
            }
        }
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    String getResponse(String input) {
        return "Duke heard: " + input;
    }
}

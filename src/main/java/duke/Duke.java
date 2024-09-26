package duke;

import duke.task.Task;

import java.util.ArrayList;

public class Duke {
    private TaskList taskList;
    private Storage storage;
    public boolean isExit;

    /**
     * Create new Duke with new task list and filepath for loading and saving data.
     */
    public Duke() {
        ArrayList<Task> tasks = new ArrayList<>();
        this.taskList = new TaskList(tasks);
        this.storage = new Storage("data/duke.txt");
        storage.loadFile(taskList);
        this.isExit = false;
    }

    public void run() {
        System.out.println(UI.welcome());
        while (!isExit) {
            try {
                String fullCommand = UI.readCommand();
                Execution execution = new Execution(fullCommand);
                UI.splitLine();
                System.out.println(execution.execute(taskList));
                storage.saveFile(taskList);
                isExit = execution.isExit;
            } catch (Exception e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } finally {
                UI.splitLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String input) {
        try {
            Execution execution = new Execution(input);
            String response = execution.execute(taskList);
            storage.saveFile(taskList);
            isExit = execution.isExit;
            return response;
        } catch (Exception e) {
            return "OOPS!!! I'm sorry, but I don't know what that means :-(";
        }
    }
}
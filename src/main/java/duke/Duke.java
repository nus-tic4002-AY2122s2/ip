package duke;

import duke.task.Task;

import java.util.ArrayList;

public class Duke {
    private TaskList taskList;

    private Duke() {
        ArrayList<Task> tasks = new ArrayList<>();
        this.taskList = new TaskList(tasks);
    }

    private void run() {
        UI.welcome();
        boolean isExit = false;
        while(!isExit) {
            try {
                String fullCommand = UI.readCommand();
                Execution execution = new Execution(fullCommand);
                UI.splitLine();
                execution.execute(taskList);
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
}

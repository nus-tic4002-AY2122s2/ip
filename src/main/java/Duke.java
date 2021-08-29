import java.util.ArrayList;

public class Duke {
    private UI ui;
    private TaskList taskList;

    private Duke(){
        this.ui = new UI();
        ArrayList<Task> tasks = new ArrayList<>();
        this.taskList = new TaskList(tasks);
    }

    private void run() {
        ui.welcome();
        boolean isExit = false;
        while(!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Execution execution = new Execution(fullCommand);
                ui.splitLine();
                execution.execute(taskList);
                isExit = execution.isExit;
            } catch (Exception e) {
                System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
            } finally {
                ui.splitLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

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
            String fullCommand = ui.readCommand();
            Command c = new Command(fullCommand);
            ui.splitLine();
            c.execute(taskList);
            isExit = c.isExit;
            ui.splitLine();
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

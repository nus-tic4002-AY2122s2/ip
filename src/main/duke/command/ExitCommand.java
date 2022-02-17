package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;


public class ExitCommand extends Command {

    public ExitCommand() {
        bExit = true;
    }

    /**
     * Writes to savefile, then prints goodbye message on console, finally flags for console to exit.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        boolean exitFlag = true;
        storage.writeToSaveFile(tasks.listTasks());
        ui.printByeMsg();
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    ui.printToUI("Interrupted exit!");
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                Platform.exit();
            }
        });
        new Thread(sleeper).start();
    }

}


package basic;

import command.Command;

import java.util.ArrayList;

/**
 * Runs basic.Duke program as long as isExit is false
 */
public class Duke {
    private Ui ui;
    private TaskList tasks;

    Duke(){
        ArrayList<String> array = new ArrayList<String>();
        tasks = new TaskList(array);
        ui = new Ui();
    }

    private void run() {
        ui.showWelcome();

        boolean isExit = false;

        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui);
                isExit = c.isExit();
            } catch (Exception e) {
                ui.printException(e);
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

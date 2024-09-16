package commands;

import exceptions.DukeException;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

import java.io.IOException;

public class HelpCommand extends Command {

    public HelpCommand() {
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException, IOException {
        ui.storeMessage("Inputs in commands (Input is described within the square brackets):\n"
                + "[description] is a string that describes the task.\n"
                + "[Date and Time] refers to the input date. It goes by the format \"dd/MM/yyyy HH:mm:ss\". "
                + "Eg. 02/12/20 10:10:10\n"
                + "[Time] refers to the Time format of \"HH:mm:ss\" "
                + "where they represent the hours, minutes and seconds\n"
                + "[option] refers to the option number. "
                + "The option number for each task can be viewed when the tasks are printed\n"
                + " as a list.(this can be seen by the command \"list\")\n"
                + "[keyword] refers to the phrase or word that you want to search for\n"
                + "\n"
                + "The commands for the respective features are after the semi-colon\":\"\n");

        AddCommand.printHelp(ui);
        RescheduleCommand.printHelp(ui);
        ChangeDoneCommand.printHelp(ui);
        DeleteCommand.printHelp(ui);
        ClearListCommand.printHelp(ui);
        ExitCommand.printHelp(ui);
        FindCommand.printHelp(ui);
        ListCommand.printHelp(ui);

    }
}

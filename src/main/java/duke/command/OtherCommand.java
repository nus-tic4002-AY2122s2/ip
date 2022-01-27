package duke.command;

import duke.dukeexception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

/**
 * list of other etc commands
 */
public class OtherCommand extends Command {
    /**
     * Constructs the OtherCommands
     * @param taskDes
     */
    public OtherCommand(String taskDes) {
        super(taskDes);
    }

    /**
     * Execute the other commands: Hi, Help and Clearlist
     * @param tasks The list of task
     * @param ui The Ui
     * @param storage The storage
     * @throws DukeException any expected error
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        switch(commandInstruction) {
        case "hi":
            ui.displayMsg("Hello to you too! :)");
            break;
        case "help":
            ui.displayListOfHelpFunction();
            break;
        case "clearlist":
            tasks.clearAll();
            ui.displayMsg("List of Tasks has all been clear, you have an empty list now.");
            break;
        default:
            throw new DukeException("Shouldn't have error here");
        }

    }


}

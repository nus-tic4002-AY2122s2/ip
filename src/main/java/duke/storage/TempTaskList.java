package duke.storage;
import duke.task.Task;
import duke.ui.Message;

/**
 * Inherent from generic TempList class,
 * TempTaskList constrains that it only stores Task type items in the list
 * Adding method to print tasks in the list
 *
 * @param <Task>
 */
public class TempTaskList<Task> extends TempList<Task> {
    public TempTaskList() {
        super();
    }

    public void print() {
        if (this.size() == 0) {
            Message.emptyList();
        }
        for (Task task : list) {
            Message.echo(task.toString());
        }
    }

}

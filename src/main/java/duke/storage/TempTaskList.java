package duke.storage;
import duke.ui.Message;
import duke.task.Task;

import java.beans.PropertyChangeSupport;

/**
 * Inherent from generic TempList class,
 * TempTaskList constrains that it only stores Task type items in the list
 * Adding method to print tasks in the list
 *
 */
public class TempTaskList extends TempList<Task> {
    public TempTaskList() {
        super();
    }

    public void print() {
        if (list.size() == 0) {
            Message.emptyList();
        }
        int i = 1;
        for (Task task : list) {
            Message.echo( i + ". " + task.toString());
            i++;
        }
    }

    public int count() {
        return list.size();
    }

    public void tellStats() {
        int numTask = this.count();
        int numDoneTask = 0;
        for (Task task : list) {
            if (task.isDone()) numDoneTask++;
        }
        Message.tellTaskNum(numTask, numDoneTask);
    }

    public void markDoneAt(int index) {
        var oldlist = list.clone();
        list.get(index).markDone();
        support.firePropertyChange("list", oldlist, list);
    }

}

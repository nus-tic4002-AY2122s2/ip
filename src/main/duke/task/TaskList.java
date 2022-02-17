package duke.task;

import java.util.ArrayList;

import duke.exception.DukeException;
import duke.exception.DukeUnknownException;
import duke.storage.Storage;


/**
 * Class representative of List of Task with helper methods.
 * contains the task list e.g., it has operations to add/delete tasks in the list.
 * Refer to More OOP.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * @param s
     * @throws DukeException
     */
    public TaskList(Storage s) throws DukeException {
        tasks = new ArrayList<>();
        s.readSaveFile(this);
    }

    /**
     * @param taskList
     * @return
     */
    public static String listTasks(ArrayList<Task> taskList) {
        String tasksStr = "";
        int i = 0;
        for (Task t : taskList) {
            tasksStr += String.format("%d: %s\n", ++i, t);
        }
        return tasksStr;
    }

    public String listTasks() {
        return listTasks(tasks);
    }

    /**
     * @return a formatted list from listTasks()
     */
    public String getTasks() {
        return listTasks();
    }

    /**
     * Parses the string passed over from the UpdateCommand (Add) and adds into the list.
     *
     * @param s
     * @return True if successfully added, else False.
     * @throws DukeException
     */
    public boolean add(String s) throws DukeException {
        Task t;
        boolean done = true;
        String[] strArr = s.split(" ");
        int startDescInd = s.indexOf(String.format("[%c]", Task.CHECKMARK)); // done
        int lastDescInd = s.length();
        if (startDescInd == -1) {
            startDescInd = s.indexOf(String.format("[%c]", Task.CROSSMARK)); //not done
            done = false;
        }
        switch (strArr[1].charAt(1)) {
        case 'D':
            //1: [D][X] tic2002 (by: today)
            lastDescInd = s.lastIndexOf(" (by: ");
            t = new Deadline(s.substring(startDescInd + 4, lastDescInd), s.substring(lastDescInd + 6, s.length() - 1));
            break;
        case 'E':
            //2: [E][X] tp visit (at: today)
            lastDescInd = s.lastIndexOf(" (at: ");
            t = new Event(s.substring(startDescInd + 4, lastDescInd), s.substring(lastDescInd + 6, s.length() - 1));
            break;
        case 'T':
            //234: [T][X] awd
            t = new ToDo(s.substring(startDescInd + 4, lastDescInd));
            break;
        default:
            throw new DukeUnknownException();
        }
        t.setDone(done);
        return tasks.add(t);
    }

    public boolean add(Task t) {
        return tasks.add(t);
    }

    /**
     * @param i
     * @return
     */
    public Task remove(int i) {
        if (i < this.size()) {
            return tasks.remove(i);
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    public Task get(int i) {
        return tasks.get(i);
    }

    /**
     * @param s
     * @return
     */
    public ArrayList<Task> find(String s) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getDescription().toLowerCase().contains(s.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }

    /**
     * @param i
     */
    public void done(int i) {
        Task currTask = get(i);
        assert currTask != null;
        currTask.setDone(true);
    }

    public int size() {
        return tasks.size();
    }

    /**
     * @param pos
     * @param t
     */
    public void edit(int pos, Task t) {
        assert pos < tasks.size();
        tasks.set(pos, t);
    }

}

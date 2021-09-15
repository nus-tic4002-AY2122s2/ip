package task_classes;

import java.util.Vector;

public class TaskList {

    private Vector<Task> list;

    public TaskList (Vector<Task> list){
        this.list = list;
    }

    public TaskList () {
        list = new Vector<>();
    }
}

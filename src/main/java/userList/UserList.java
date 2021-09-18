package userList;

import java.util.ArrayList;
import task.Task;

public class UserList {
    private ArrayList<Task> list = new ArrayList<>();

    public void addItem (Task task){
        this.list.add(task);
    }

    public ArrayList<Task> getList() { return this.list; }

    public void removeItem (int index) {
        this.list.remove(index);
    }

    public ArrayList<String> getSerializedList () {
        ArrayList<String> taskList = new ArrayList<>();

        for (Task task : this.list) {
            taskList.add(task.toString());
        }

        return taskList;
    }
}

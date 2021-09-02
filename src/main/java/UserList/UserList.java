package UserList;

import java.util.ArrayList;
import task.Task;

public class UserList {
    private ArrayList<Task> list = new ArrayList<>();

    public void addItem (String item){
        Task task = new Task(item);
        this.list.add(task);
    }

    public ArrayList<Task> getList() { return this.list; }

    public ArrayList<String> getSerializedList () {
        ArrayList<String> taskList = new ArrayList<>();

        for (Task task : this.list) {
            String status = "[" + task.getStatusIcon() + "]";
            taskList.add(status + " " + task.getDescription());
        }

        return taskList;
    }


}

package taskList;

import java.util.ArrayList;
import exception.ErrorHandler;
import task.Task;

/**
 * Serve as a store for saving user command
 */
public class TaskList {
    /**
     * A list of different task type
     */
    private ArrayList<Task> list = new ArrayList<>();

    public TaskList() {
    }

//    private TaskList(Builder builder) {
//        if(builder.fileData.length > 0) {
//
//        }

//    public static class Builder {
//        private String [] fileData = new String[0] ;
//
//        public Builder initWitFileData(String [] fileData) {
//            this.fileData = fileData;
//            return this;
//        }
//
//        public Builder init() {
//            return this;
//        }
//
//        public TaskList build() {
//            return new TaskList(this);
//        }
//    }

    /**
     * @param task is a type of task, could be Event, Deadline
     * @throws ErrorHandler customized error
     */
    public void addItem (Task task) throws ErrorHandler {
        this.list.add(task);
    }

    public ArrayList<Task> getList() { return this.list; }

    /**
     * @param index remove data from the list t given index
     */
    public void removeItem (int index) {
        this.list.remove(index);
    }
  
    /**
     * @return list of string which is representing all tasks information in a readable string format.
     * For printing purpose
     */
    public ArrayList<String> getSerializedList () {
        ArrayList<String> taskList = new ArrayList<>();

        for (Task task : this.list) {
            taskList.add(task.toString());
        }

        return taskList;
    }
}


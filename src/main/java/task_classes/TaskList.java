package task_classes;

import exceptions.DukeStorageError;
import exceptions.DukeTaskInputException;

import java.util.Vector;

public class TaskList {

    private static Vector<Task> list;

    public TaskList (Vector<Task> taskList){
        list = taskList;
    }

    public TaskList () {
        list = new Vector<>();
    }

    public static void deleteTask(int taskIndex) throws DukeTaskInputException {
        if(list.isEmpty()){
            throw new DukeTaskInputException("taskListEmpty");
        }

        list.remove(taskIndex);
    }

    public static void addTask(Task task) {
        list.add(task);
    }

    public static String getDateTime (int taskIndex) throws DukeStorageError {
        Task task = list.get(taskIndex);

        String taskType = task.getType();

        switch (taskType) {
            case "E":
                return task.getAt();
            case "D":
                return task.getBy();
        }

        throw new DukeStorageError();
    }

    public Task getTask(int index) {
        return list.get(index);
    }

    public static void toPrintEntireTaskList(){
        if(list.isEmpty()){
            System.out.println("     Here is no task in your list.");
            return;
        }

        System.out.println("     Here are the task(s) in your list:");

        for(int i=0; i < list.size(); i++){
            int j = i + 1;
            Task task = list.get(i);

            System.out.print("     " + j + "." +
                    "[" + task.getType() + "]" +
                    "[" + task.getStatusIcon() + "] " + task.getDescription());

            String taskType = task.getType();

            switch(taskType){
                case "E":
                    String eventDateTime = task.getAt();
                    System.out.println(" (at: " + eventDateTime + ")");

                    break;
                case "D":
                    String deadlineDateTime = task.getBy();
                    System.out.println(" (by: " + deadlineDateTime + ")");

                    break;
                default:
                    System.out.println("");
            }
        }
    }

    public int size() {
        if(list.isEmpty()){
            return 0;
        }

        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static Vector<Task> getVectorList() {
        return list;
    }
}

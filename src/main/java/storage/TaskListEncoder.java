package storage;

import task_classes.Task;

import java.util.Vector;

class TaskListEncoder {


    static Vector<String> encodeTaskList(Vector<Task> list){

        Vector<String> encodedTaskList = new Vector<>();

        for(Task task : list){
            String encodedTask = encodeSingleTask(task);

            encodedTaskList.add(encodedTask);
        }

        return encodedTaskList;
    }

    private static String encodeSingleTask (Task task){
        String taskType = task.getType();
        String taskDescription = task.getDescription();
        String taskStatus = task.getStatusIcon();

        if(taskStatus.equals("X")){
            taskStatus = "1";
        } else {
            taskStatus = "0";
        }

        String encodedTask = taskType + " | " + taskStatus + " | " + taskDescription;
        String dateTime;

        switch(taskType){
            case "E":
                dateTime = task.getAt();
                encodedTask = encodedTask + " | " + dateTime;

                break;
            case "D":
                dateTime = task.getBy();
                encodedTask = encodedTask + " | " + dateTime;

                break;
        }

        return encodedTask;
    }
}

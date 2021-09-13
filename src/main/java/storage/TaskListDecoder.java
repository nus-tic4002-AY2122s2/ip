package storage;

import exceptions.DukeStorageError;
import task_classes.Deadline;
import task_classes.Event;
import task_classes.Task;
import task_classes.Todo;

import java.util.Vector;

class TaskListDecoder {

    static Vector<Task> decodeTaskList(Vector<String> storageInformation) throws DukeStorageError {
        Vector<Task> decodedTaskList = new Vector<>();

        for(String singleTaskInfo : storageInformation){
            Task task = decodeTask(singleTaskInfo);

            decodedTaskList.add(task);
        }


        return decodedTaskList;
    }


    private static Task decodeTask(String taskString) throws DukeStorageError {

        String[] parts = taskString.split(" \\| ");
        String taskType = parts[0];
        String taskDescription = parts[2];
        boolean taskStatus = !parts[1].equals("0");

        if(parts.length == 3){ //todo type with correct length

            System.out.println("Todo " + parts[2]);
            return new Todo(taskDescription, taskStatus);

        } else if (parts.length == 4){ // deadline or event with correct length
            if(taskType.equals("E")){

                System.out.println("Event " + parts[2]);
                String dateTime = parts[3];
                return new Event(taskDescription, taskStatus, dateTime);

            } else if (taskType.equals("D")){

                System.out.println("Deadline " + parts[2]);
                String dateTime = parts[3];
                return new Deadline(taskDescription, taskStatus, dateTime);

            } else {
                throw new DukeStorageError();
            }
        } else {
            throw new DukeStorageError();
        }
    }
}

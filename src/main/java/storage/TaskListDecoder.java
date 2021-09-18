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

            return new Todo(taskDescription, taskStatus);

        } else if (parts.length == 5 && taskType.equals("E")) { // event with correct length

            //  type [0] | status [1] | description [2] | starting [3] | ending [4]
            return new Event(taskDescription, taskStatus, parts[3], parts[4]);

        } else if (parts.length == 4 && taskType.equals("D")){ // deadline with correct length
             // type [0] | status [1] | description [2] | deadline date [3]
            return new Deadline(taskDescription, taskStatus, parts[3]);

        } else {
            throw new DukeStorageError();
        }
    }
}

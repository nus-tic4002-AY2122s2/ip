package storage;

import task_classes.Task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class StorageInLocal {


    private Path path;
    private Vector<Task> List = new Vector<>();

    /**
     * An default file path which is "data/duke.txt"
     */
    private static final String DEFAULT_STORAGE_FILEPATH = "data/duke.txt";

    /**
     * Constructs StorageFile with default file path
     */
    public StorageInLocal() {
        this.path = Paths.get(DEFAULT_STORAGE_FILEPATH);
    }


    /**
     * To check whether the default file path is exist
     * @return return boolean whether the default file path is exist
     */
    public boolean FileExist(){
        return (Files.exists(this.path));
    }

    public void saveTaskListToLocal(){
        Vector<String> taskInString = new Vector<>();

        for (Task task : List) {
            String taskString = convertFromTaskToString(task);

            taskInString.add(taskString);
        }
    }

    private String convertFromTaskToString(Task currentTask){
        String taskType = currentTask.getType();
        String description = currentTask.getDescription();
        String taskStatus = currentTask.getStatusIcon();
        String taskInString = taskType;
        String dateTime;

        taskInString = taskInString.concat(" | ");
        taskInString = taskInString.concat(taskStatus);
        taskInString = taskInString.concat(" | ");
        taskInString = taskInString.concat(description);

        switch(taskType){
            case "E":
                dateTime = currentTask.getAt();
                taskInString = taskInString.concat(" | ");
                taskInString = taskInString.concat(dateTime);
                break;
            case "D":
                dateTime = currentTask.getBy();
                taskInString = taskInString.concat(" | ");
                taskInString = taskInString.concat(dateTime);
                break;
        }

        return taskInString;
    }
}


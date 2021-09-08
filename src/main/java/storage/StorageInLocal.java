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
    private Vector<Task> List;

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
     * To check whether the file path input is valid
     * @param filePath file Path in String
     * @return return boolean whether valid
     */
    private static boolean isValidPath(Path filePath) {
        return filePath.toString().endsWith(".txt");
    }

    public StorageInLocal(Vector<Task> List){
        this.List = List;
    }

    /**
     * To check whether the default file path is exist
     * @return return boolean whether the default file path is exist
     */
    public boolean FileExist(){
        return (Files.exists(this.path));
    }

    public void saveTaskListToLocal(){
        File taskListTxtFile = new File(localDir);

        Vector<String> taskInString = new Vector<>();

        for (Task task : List) {
            String taskString = convertFromTaskToString(task);

            taskInString.add(taskString);
        }

        File newTxt = new File (localDir, "duke_task_list.txt");
    }

    private String convertFromTaskToString(Task currentTask){

    }
}


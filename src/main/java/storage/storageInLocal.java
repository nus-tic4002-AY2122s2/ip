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


public class storageInLocal {


    private static Path path;
    private static final Path rootPath = Paths.get("").toAbsolutePath();
    private static final String rootDir = rootPath.normalize().toString();

    /**
     * An default file path which is "data/duke.txt"
     */
    private static final String DEFAULT_STORAGE_FILEPATH = "data/duke.txt";

    /**
     * Constructs StorageFile with default file path
     */
    public storageInLocal() {
        path = Paths.get(rootDir + "/" + DEFAULT_STORAGE_FILEPATH);
    }

    /**
     * To add all the Task which in String type in the list into txt file as local storage
     *
     * @param List all the task
     * @throws IOException to handle all errors for FileWriter
     */
    private void toSaveTaskListToLocal(Vector<Task> List) throws IOException {

        if(List.size() == 0){
            return;
        }

        Vector<String> taskListInString = TaskListEncoder.encodeTaskList(List);

        String fileDirectory = String.valueOf(DEFAULT_STORAGE_FILEPATH);

        //To clear content of existing txt file
        FileWriter fw = new FileWriter(fileDirectory);
        fw.write("");
        fw.close();

        //Start writing Task(s) in Vector<String> list into the new txt file
        FileWriter newFw = new FileWriter(fileDirectory, true);

        for (String task : taskListInString) {
            newFw.write(task + System.lineSeparator());
        }

        newFw.close();
    }

    /**
     * To check whether the default file path is exist
     * @return return boolean whether the default file path is exist
     */
    private boolean fileDoExist(){
        return (Files.exists(path));
    }

    /**
     * To check whether the directory folder path is exist
     *
     * @return return boolean whether the directory folder path is exist
     */
    private boolean dirDoExist() { return Files.exists(Paths.get(rootDir + "/data"));}

    /**
     * The function to transfer all the Task information by using Encoder function from Vector<Task> List to String and store into txt file
     * @param List Vector<Task> List
     //* @param ToDoAfterList Vector<ToDoAfter> ToDoAfter task list
     * @throws IOException If the FileWrite those kind of function got any error, an error will be thrown to user
     //* @throws EncoderUnknowError If Encoder has any error, an error will be thrown to user
     */
    public void transferToFile(Vector<Task> List) throws IOException {

        if(!fileDoExist()){
            if(!dirDoExist()){
                Files.createDirectories(Paths.get(rootDir + "/data"));
            }

            Files.createFile(path);
        }

        toSaveTaskListToLocal(List);
    }

    public Vector<Task> extractTaskFromTxt(){
        Vector<Task> list = new Vector<>();

        File file = new File(DEFAULT_STORAGE_FILEPATH);


        return list;
    }
}


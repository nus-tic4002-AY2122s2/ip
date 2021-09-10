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
    public StorageInLocal() {
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

        Vector<String> taskListInString = toConvertTaskListIntoStringTypeList(List);

        System.out.println(taskListInString.get(1));

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

    private boolean dirDoExist() { return Files.exists(Paths.get(rootDir + "/data"));}

    /**
     * To convert all the task in the task list to String type and store it into Vector<String> type task List
     * Each Task type task converted to String type in the format:
     * Task type + " | " + task status + " | " + task description + " | " + dateTime
     * DateTime is for Event and Deadline type task only
     *
     * @param List The task list in Vector<<ask> type
     * @return the task list in Vector<String> type
     */
    private static Vector<String> toConvertTaskListIntoStringTypeList(Vector<Task> List){
        Vector<String> taskInString = new Vector<>();

        for (Task task : List) {
            String taskString = convertFromTaskToString(task);

            taskInString.add(taskString);
        }

        return taskInString;
    }

    private static String convertFromTaskToString(Task currentTask){
        String taskType = currentTask.getType();
        String description = currentTask.getDescription();
        String taskStatus = currentTask.getStatusIcon();

        if(taskStatus.equals("x")){
            taskStatus = "1";
        } else {
           taskStatus = "0";
        }

        String taskInString = taskType + " | " + taskStatus + " | " + description;
        String dateTime;

        switch(taskType){
            case "E":
                dateTime = currentTask.getAt();
                taskInString = taskInString + " | " + dateTime;

                break;
            case "D":
                dateTime = currentTask.getBy();
                taskInString = taskInString + " | " + dateTime;

                break;
        }

        return taskInString;
    }

    /**
     * The function to transfer all the Task information by using Encoder function from Vector<Task> List to String and store into txt file
     * @param List Vector<Task> List
     //* @param ToDoAfterList Vector<ToDoAfter> ToDoAfter task list
     * @throws IOException If the FileWrite those kind of function got any error, an error will be thrown to user
     //* @throws EncoderUnknowError If Encoder has any error, an error will be thrown to user
     */
    public void TransferToFile(Vector<Task> List) throws IOException {

        if(!fileDoExist()){
            if(!dirDoExist()){
                Files.createDirectories(Paths.get(rootDir + "/data"));
            }

            Files.createFile(path);
        }

        toSaveTaskListToLocal(List);
    }
}


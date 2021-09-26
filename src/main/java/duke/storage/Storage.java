package duke.storage;

import duke.dukeexception.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import duke.task.TaskList;

public class Storage {

    private static String filePath;

    /**
     * Constructs the storage class to store the file path of the txt file
     * @param filePath the file path of the txt file
     */
    public Storage(String filePath){
        this.filePath = filePath;
    }

    public static java.nio.file.Path pathFinder() throws IOException, DukeException{
        String fileName = filePath;
        if(filePath.contains("/")) {
            fileName = filePath.substring(filePath.lastIndexOf('/'));
            String dirString = filePath.substring(0, filePath.lastIndexOf('/'));
            java.nio.file.Path folderDir = java.nio.file.Paths.get(dirString);
            boolean directoryExists = java.nio.file.Files.exists(folderDir);
            if(!directoryExists){
                java.nio.file.Files.createDirectories(folderDir);
            }
        }
        if(!fileName.contains(".txt")){
            throw new DukeException("storage files need to be in txt format");
        }


        return java.nio.file.Paths.get(filePath);

    }


    /**
     * Write into a txt file
     * @param lists list of the task to be written into the txt file
     */
    public static void save(TaskList lists) throws DukeException {
        try {
            java.nio.file.Path filePath = pathFinder();
            FileWriter fileWrite = new FileWriter(filePath.toString());
            for (int i = 0; i < lists.getSize(); i++) {
                String storingTask = convertTaskStoring(lists.getTask(i), i);
                fileWrite.write(storingTask);
            }
            fileWrite.close();
        }catch(IOException | DukeException e){
            throw new DukeException("error:" + e.getMessage() + ".");

        }

    }

    private static String convertTaskStoring(Task task, int index) throws DukeException, IllegalStateException {
        String storingTask;
        switch (task.getTaskType()) {
            case EVENT:
                Event event = (Event) task;
                storingTask = (index + 1) + " | E"
                        + " | " + (event.getIsDone() ? "1" : "0")
                        + " | " + event.getTaskDescription()
                        + " | " + event.getDateTimeString()
                        + System.lineSeparator();
                break;
            case DEADLINE:
                Deadline deadlines = (Deadline) task;
                storingTask = (index + 1) + " | D"
                        + " | " + (deadlines.getIsDone() ? "1" : "0")
                        + " | " + deadlines.getTaskDescription()
                        + " | " + deadlines.getDateTimeString()
                        + System.lineSeparator();
                break;
            case TODO:
                storingTask = (index + 1) + " | T"
                        + " | " + (task.getIsDone() ? "1" : "0")
                        + " | " + task.getTaskDescription()
                        + System.lineSeparator();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + task.getTaskType());
        }
        return storingTask;
    }

    public static ArrayList<Task> load() throws DukeException {
        try {
            ArrayList<Task> tasks = getListOfTask();
            return tasks;
        }catch (IOException e) {
            throw new DukeException("Error with creating dir");
        }

    }

    private static ArrayList<Task> getListOfTask() throws IOException, DukeException {
        java.nio.file.Path filePath = pathFinder();
        File f = new File(filePath.toString()); // create a File for the given file path
        if(f.length() == 0){
            return new ArrayList<Task>();
        }
        ArrayList<Task> tasks = new ArrayList<>();
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            Task task = convertTaskFromFile(s.nextLine());
            task.setTaskIndex(tasks.size());
            tasks.add(task);
        }

        return tasks;
    }

    private static Task convertTaskFromFile(String text) throws DukeException {
        Task task;
        int firstDivider = text.indexOf("| ");
        String taskType = text.substring(firstDivider + 2, firstDivider + 3);
        String taskDoneString = text.substring(firstDivider + 6, firstDivider +7);
        String taskDetails = text.substring(firstDivider + 10);
        boolean isDone = false;
        if(!(taskDoneString.contains("0")||taskDoneString.contains("1"))) {

            throw new DukeException("Unknown boolean");
        }
        if(taskDoneString.contains("1")){
            isDone = true;
        }
        if(taskDetails.contains(" | ")){
            int timeDivider = taskDetails.indexOf(" | ");
            String taskDes = taskDetails.substring(0, timeDivider);
            String taskTime = taskDetails.substring(timeDivider + 3);
            task = creatingEventOrDeadline(taskType, taskDes, taskTime);
            task.editDone(isDone);
            return task;
        }
        if(!taskType.contains("T")){
            throw new DukeException("Unknown task type");
        }
        task = new ToDo(taskDetails);
        task.editDone(isDone);

        return task;
    }

    private static Task creatingEventOrDeadline(String taskType, String taskDes, String taskDateTime) throws DukeException {
        if(taskType.contains("D")){
            return new Deadline(taskDes,taskDateTime);
        }
        if(taskType.contains("E")){
            return new Event(taskDes,taskDateTime);
        }

        throw new DukeException("Unknown task Type");
    }

}

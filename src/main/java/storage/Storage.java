package storage;
import tasklist.TaskList;
import tasklist.Deadline;
import tasklist.Event;
import tasklist.Task;
import tasklist.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = "/" + filePath;
    }

    /****
     * Writes tasks to file
     *
     * @param fileContent the tasks stored in the file
     * @throws FileNotFoundException if file can't be found
     */
    public void writeToFile(String fileContent) throws FileNotFoundException {
        File f = new File(filePath);

        PrintWriter pw = new PrintWriter(f);
        pw.println(fileContent);
        pw.close();
    }

    /****
     * Loads tasks from file
     *
     * @throws IOException if file can't be found
     * @param tasks the TaskList object
     */
    public void loadFile(TaskList tasks) throws IOException {
        String[] storeFilePathArray = filePath.split("/");
        File directory = new File("/" + storeFilePathArray[0]);
        File f = new File(filePath);
        if (! directory.exists()){
            directory.mkdir();
            f.createNewFile();
        }

        Scanner sc = new Scanner(f);
        while (sc.hasNext()) {
            loadFormat(tasks, sc.nextLine());
        }
    }

    /****
     * Adds tasks to taskList from file
     *
     * @param fileContent the tasks stored in the file
     */
    void loadFormat(TaskList tasks, String fileContent) {
        System.out.println(fileContent);
        Task t;
        String[] storeArray = fileContent.split(" \\| ");
        switch (storeArray[0]) {
        case "T":
            t = new ToDo(storeArray[2], isDone(Integer.parseInt(storeArray[1])));
            break;

        case "D":
            try {
                t= new Deadline(storeArray[2], isDone(Integer.parseInt(storeArray[1])),storeArray[3]);
                break;
            } catch (ArrayIndexOutOfBoundsException e){
                t= new Deadline(storeArray[2], isDone(Integer.parseInt(storeArray[1])));
                break;
            }
            
        case "E":
            try {
                t = new Event(storeArray[2], isDone(Integer.parseInt(storeArray[1])),storeArray[3]);
            } catch (ArrayIndexOutOfBoundsException e){
                t = new Event(storeArray[2], isDone(Integer.parseInt(storeArray[1])));
            }
            break;

        default:
            throw new IllegalStateException("Unexpected value: " + storeArray[0]);
        }
        tasks.add(t);
    }

    /****
     * Returns the boolean status of task
     *
     * @param value the status of task stored in the file
     * @return boolean status of task
     */
     Boolean isDone (Integer value) {
        return value == 1;
    }
}
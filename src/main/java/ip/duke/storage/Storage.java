package ip.duke.storage;

import ip.duke.task.Task;
import ip.duke.tasklist.TaskList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    // Text file for saving all online records stored in TASKS database
    private static String FILE_PATH;

    public Storage(String filePath) {
        FILE_PATH = filePath;
    }

    public void setFilePath(String path){
        FILE_PATH = path;
    }

    public static String getFilePath() {
        return FILE_PATH;
    }

    public static void appendToFile(int index) {
        BufferedWriter disk = null;

        try {
            disk = new BufferedWriter(new FileWriter(FILE_PATH, true));
            disk.write(TaskList.getItem(index).toFileString() + System.lineSeparator());

        } catch (IOException e) {
            System.out.print("LisGenie : ");
            System.out.println("File access problem... " + e.getMessage());

        } finally {
            TaskList.toClose(disk);
        }
    }

    public static void writeToFile() {
        BufferedWriter disk = null;

        try {
            disk = new BufferedWriter(new FileWriter(FILE_PATH));

            for (Task item : TaskList.getList()) {
                disk.write(item.toFileString() + System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.print("LisGenie : ");
            System.out.println("File access problem... " + e.getMessage());

        } finally {
            TaskList.toClose(disk);
        }
    }
}

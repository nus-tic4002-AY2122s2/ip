package edu.nus.duke.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import edu.nus.duke.exception.DukeInvalidTaskIndexException;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.ui.Ui;

/**
 * Class that deals with loading tasks from the file and saving tasks in the file
 */
public class Storage {
    private static final String SAVE_SEP = ";";
    private final String filePath;

    /**
     * Constructor of Storage class.
     *
     * @param filePath File path of txt storage.
     * @param taskList TaskList to be saved.
     */
    public Storage(String filePath, TaskList taskList) {
        this.filePath = filePath;
        File f = new File(this.filePath);
        if (f.isFile()) {
            loadData(f, taskList);
        }
    }

    /**
     * Return string of save separator.
     *
     * @return string of save separator.
     */
    public static String getSaveSep() {
        return SAVE_SEP;
    }

    private void loadData(File f, TaskList taskList) {
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine();
                try {
                    taskList.addTask(line.split(SAVE_SEP));
                } catch (ArrayIndexOutOfBoundsException e) {
                    Ui.printMessageExit("Bad data in " + filePath);
                } catch (DukeInvalidTaskIndexException e) {
                    Ui.printMessageExit("Invalid task index in " + filePath);
                } catch (DateTimeParseException e) {
                    Ui.printMessageExit("Invalid datetime in " + filePath);
                }
            }
        } catch (FileNotFoundException e) {
            Ui.printMessageExit(filePath + " not found!");
        }

    }

    private void createParentDir(String filePath) {
        Path path = Paths.get(filePath).getParent();
        if (path == null || Files.isDirectory(path)) {
            return;
        }
        try {
            Files.createDirectory(path);
        } catch (IOException e) {
            Ui.printMessageExit(e.getMessage());
        }
    }

    /**
     * Write String to file.
     *
     * @param txt String to be written.
     */
    public void writeToFile(String txt) {
        createParentDir(filePath);
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write(txt);
            fw.close();
        } catch (IOException e) {
            Ui.printMessageExit(e.getMessage());
        }
    }
}

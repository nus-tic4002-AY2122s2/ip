package duke.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import duke.exception.DukeException;
import duke.task.TaskList;

/**
 * deals with loading tasks from the file and saving tasks in the file. Refer to More OOP.
 */
public class Storage {
    private String pathStr;

    public Storage(String pathStr) {
        this.pathStr = (!pathStr.isEmpty() || !pathStr.isBlank()) ? pathStr : "duke.txt";
    }

    /**
     * @param t
     * @throws DukeException
     */
    public void readSaveFile(TaskList t) throws DukeException {
        File f = new File(pathStr);
        if (!f.exists()) {
            System.out.println("Save file not found. Creating new file!");

            f = writeToSaveFile("");
            System.out.println(f.getAbsolutePath());
        }
        loadSaveFile(f, t);
    }

    /**
     * @param f
     * @param t
     * @throws DukeException
     */
    public void loadSaveFile(File f, TaskList t) throws DukeException {
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                t.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(String.format("%s", e.getMessage()));
        }
    }

    /**
     * @param s string representation of data to be saved.
     * @return Writes s to savefile at ./data/duke.txt, overwriting the original content.
     */
    public File writeToSaveFile(String s) {
        File f = new File(pathStr);
        Path p = f.toPath();

        try {
            if (!Files.exists(p.getParent())) {
                //System.out.println(String.format("%s directory does not exist.", p.getParent().toAbsolutePath()));
                p.getParent().toFile().mkdir();
            }
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(pathStr);
            fw.write(s);
            fw.close();
        } catch (IOException e) {
            System.out.println(String.format("%s", e.getMessage()));
        }
        return f;
    }

}

package storage;

import tasks.Deadline;
import tasks.Event;
import tasks.TaskList;
import ui.Ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * This represents the Files access. The various objects are used to access the file/directory
 * location for either writing or reading on the file.
 */
public class Storage {

    private File directory;
    private File fi;
    private String filePath;

    //For reading files
    private FileReader fr;
    private BufferedReader br;

    private ArrayList<String[]> parsedFile;


    /**
     * This is the constructor for the Storage Class.
     *
     * @param filePath This is the filePath of the text file.
     */
    public Storage(String filePath, Ui ui) throws IOException {

        this.directory = new File("data");
        if (this.directory.isDirectory() == false || this.directory.exists() == false) {
            ui.storeMessage("Directory \"data\" is not found, creating a new one");
            this.directory.mkdir();
        }

        this.fi = new File(filePath);

        if (this.fi.isFile() == false || this.fi.exists() == false) {
            ui.storeMessage("File \"duke.text\" is not found, creating a new one");
            this.fi.createNewFile();
        }

        this.filePath = filePath;
    }

    /**
     * This is a mutator. It writes the Task List details into a file.
     *
     * @param tasks This is the list of tasks that the user has entered.
     */
    public String save(TaskList tasks) throws IOException {
        String reply = "";

        FileWriter fw = new FileWriter(this.filePath);

        int size = tasks.getSize();
        if (size == 0) {
            return ("Task List is empty. Nothing to save.");

        }

        String temp = "";
        String text = "";
        String firstPart;
        String secPart = "";
        int done = 0;

        for (int i = 0; i < size; i++) {
            temp = tasks.get(i).getClass().toString();
            switch (temp) {
            case "class tasks.Task":
                firstPart = "O | ";
                break;
            case "class tasks.ToDo":
                firstPart = "T | ";
                break;
            case "class tasks.Deadline":
                firstPart = "D | ";
                secPart = " | " + ((Deadline) tasks.get(i)).getBy();
                break;
            case "class tasks.Event":
                firstPart = "E | ";
                secPart = " | " + ((Event) tasks.get(i)).getAt();
                break;
            default:
                reply = reply + ("Did not get Class from Task List:" + tasks.get(i).toString());
                continue;
            }

            done = (tasks.get(i).getIsDone()) ? 1 : 0;
            text = firstPart + done + " | " + tasks.get(i).getDescription() + secPart;
            fw.write(text + System.lineSeparator());
            text = "";
            secPart = "";

        }
        fw.close();
        return reply;
    }

    /**
     * This is a mutator that loads the task lists from the file.
     * It will return a list of tasks in form of an ArrayList of Strings. These Strings will be used for
     * the initialisation of TaskList
     *
     * @return a list of tasks that are written as strings
     */
    public ArrayList<String[]> load() throws IOException {
        this.fi = new File(this.filePath);
        this.fr = new FileReader(this.fi);
        this.br = new BufferedReader(this.fr);
        this.parsedFile = new ArrayList<String[]>();
        String line;

        while ((line = this.br.readLine()) != null) {
            this.parsedFile.add(line.split(" \\| "));
        }
        this.fr.close();
        return this.parsedFile;
    }

}

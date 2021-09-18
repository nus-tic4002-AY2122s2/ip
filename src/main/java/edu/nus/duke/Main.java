package edu.nus.duke;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.task.Todo;
import edu.nus.duke.task.Deadline;
import edu.nus.duke.task.Event;
import edu.nus.duke.exception.DukeException;

public class Main {
    // Variables
    private final String FILE_PATH = "data/duke.txt";
    private final String SAVE_SEP = ";";
    private final String CMD_TODO = "todo";
    private final String CMD_DEADLINE = "deadline";
    private final String CMD_EVENT = "event";
    private Ui ui;
    private TaskList taskList;

    // Constructor
    public Main() {
        ui = new Ui();
        taskList = new TaskList();

        try {
            initApp();
        } catch (FileNotFoundException e) {
            Ui.printMessage(FILE_PATH + " not found!");
            return;
        } catch (DukeException e) {
            Ui.printMessage("Bad data in " + FILE_PATH);
            return;
        }
        try {
            runApp();
        } catch (IOException e) {
            Ui.printMessage(e.getMessage());
            return;
        }
        Ui.printMessage("Bye. Hope to see you again soon!");
    }

    // Methods
    private void loadData(File f) throws FileNotFoundException, DukeException {
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            try {
                taskList.addTask(line.split(SAVE_SEP));
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new DukeException();
            }
        }
    }

    private void initApp() throws FileNotFoundException, DukeException {
        File f = new File(FILE_PATH);
        if (f.isFile()) {
            loadData(f);
        }
    }

    private void createParentDir(String filePath) throws IOException {
        Path path = Paths.get(filePath).getParent();
        if (path == null || Files.isDirectory(path)) {
            return;
        }
        Files.createDirectory(path);
    }

    private void writeToFile(String filePath, String txt) throws IOException {
        createParentDir(filePath);
        FileWriter fw = new FileWriter(filePath);
        fw.write(txt);
        fw.close();
    }

    private boolean isAddTask(String inputTxt) {
        return (inputTxt.startsWith(CMD_TODO) || inputTxt.startsWith(CMD_DEADLINE) || inputTxt.startsWith(CMD_EVENT));
    }

    private void processTask(String inputTxt) throws DukeException, ArrayIndexOutOfBoundsException {
        if (inputTxt.split(" ").length == 1) {
            throw new DukeException();
        }

        if (inputTxt.startsWith(CMD_TODO)) {
            taskList.addTask( new Todo(inputTxt.substring(5)) );
        } else if (inputTxt.startsWith(CMD_DEADLINE)) {
            String[] deadlineSplit = inputTxt.substring(9).split("/by");
            taskList.addTask( new Deadline(deadlineSplit[0].trim(), deadlineSplit[1].trim()) );
        } else if (inputTxt.startsWith(CMD_EVENT)) {
            String[] eventSplit = inputTxt.substring(6).split("/at");
            taskList.addTask( new Event(eventSplit[0].trim(), eventSplit[1].trim()) );
        }
    }

    private void processInput(String inputTxt) throws DukeException, IndexOutOfBoundsException {
        if (inputTxt.equals("list")) {
            String message = "Here are the tasks in your list:\n" + taskList.printTasks();
            Ui.printMessage(message, false);
            Ui.printMessage("Total tasks: " + taskList.getListSize());
        } else if (inputTxt.startsWith("done")) {
            int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
            try {
                taskList.doneTask(idx);
            } catch (IndexOutOfBoundsException e) {
                Ui.printMessage("Invalid/missing index");
            }
        } else if (inputTxt.startsWith("delete")) {
            int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
            try {
                taskList.deleteTask(idx);
            } catch (IndexOutOfBoundsException e) {
                Ui.printMessage("Invalid/missing index");
            }
        } else {
            throw new DukeException();
        }
    }

    private boolean isBadInput(String input) {
        if (input.contains(SAVE_SEP)) {
            Ui.printMessage("'" + SAVE_SEP + "' is not allowed!");
            return true;
        }
        return false;
    }

    private void runApp() throws IOException {
        Scanner userInput = new Scanner(System.in);
        String inputTxt = userInput.nextLine();
        while (!inputTxt.equals("bye")) {
            if (isBadInput(inputTxt)) {
                inputTxt = userInput.nextLine();
                continue;
            }

            if (isAddTask(inputTxt)) {
                try {
                    processTask(inputTxt);
                } catch (DukeException e) {
                    Ui.printMessage("OOPS!!! The description of a " + inputTxt + " cannot be empty.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    Ui.printMessage("Invalid input");
                }
            } else {
                try {
                    processInput(inputTxt);
                } catch (DukeException e) {
                    Ui.printMessage("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }

            writeToFile(FILE_PATH, taskList.printForFile());

            inputTxt = userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

package edu.nus.duke;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.Task;
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
    private ArrayList<Task> tasks = new ArrayList<>();
    private Ui ui;

    // Constructor
    public Main() {
        ui = new Ui();

        try {
            initApp();
        } catch (FileNotFoundException e) {
            ui.printMessage(FILE_PATH + " not found!");
            return;
        } catch (DukeException e) {
            ui.printMessage("Bad data in " + FILE_PATH);
            return;
        }
        try {
            runApp();
        } catch (IOException e) {
            ui.printMessage(e.getMessage());
            return;
        }
        ui.printMessage("Bye. Hope to see you again soon!");
    }

    // Methods
    private void loadTask(String line) throws DukeException, ArrayIndexOutOfBoundsException {
        String[] elements = line.split(SAVE_SEP);
        String taskType = elements[0];
        boolean isDone = elements[1].equals("1");
        String taskName = elements[2];
        switch (taskType) {
        case "T":
            tasks.add(new Todo(taskName, isDone));
            break;
        case "D":
            String by = elements[3];
            tasks.add(new Deadline(taskName, by, isDone));
            break;
        case "E":
            String at = elements[3];
            tasks.add(new Event(taskName, at, isDone));
            break;
        default:
            throw new DukeException();
        }
    }

    private void loadData(File f) throws FileNotFoundException, DukeException {
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String line = s.nextLine();
            try {
                loadTask(line);
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

    private void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTask());
        }
    }

    private String generateFileOutput() {
        StringBuilder output = new StringBuilder();
        for (Task task : tasks) {
            output.append(task.printToSave());
            output.append(System.lineSeparator());
        }
        return output.toString();
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

    private void addTask(Task task) {
        tasks.add(task);
        ui.printMessage("added: " + task.getTask(), false);
    }

    private void processTask(String inputTxt) throws DukeException, ArrayIndexOutOfBoundsException {
        if (inputTxt.split(" ").length == 1) {
            throw new DukeException();
        }

        if (inputTxt.startsWith(CMD_TODO)) {
            addTask( new Todo(inputTxt.substring(5)) );
        } else if (inputTxt.startsWith(CMD_DEADLINE)) {
            String[] deadlineSplit = inputTxt.substring(9).split("/by");
            addTask( new Deadline(deadlineSplit[0].trim(), deadlineSplit[1].trim()) );
        } else if (inputTxt.startsWith(CMD_EVENT)) {
            String[] eventSplit = inputTxt.substring(6).split("/at");
            addTask( new Event(eventSplit[0].trim(), eventSplit[1].trim()) );
        }
    }

    private void setDone(String inputTxt) throws IndexOutOfBoundsException {
        int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
        tasks.get(idx).setDone();
        String message = "Nice! I've marked this as done:\n" + tasks.get(idx).getTask();
        ui.printMessage(message);
    }

    private void deleteTask(String inputTxt) throws IndexOutOfBoundsException {
        int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
        String task = tasks.get(idx).getTask();
        tasks.remove(idx);
        String message = "Noted. I've removed this task:\n" + task;
        ui.printMessage(message, false);
    }

    private void processInput(String inputTxt) throws DukeException {
        if (inputTxt.equals("list")) {
            printList();
        } else if (inputTxt.startsWith("done")) {
            try {
                setDone(inputTxt);
            } catch (IndexOutOfBoundsException e) {
                ui.printMessage("Invalid/missing index");
            }
        } else if (inputTxt.startsWith("delete")) {
            try {
                deleteTask(inputTxt);
            } catch (IndexOutOfBoundsException e) {
                ui.printMessage("Invalid/missing index");
            }
        } else {
            throw new DukeException();
        }
    }

    private boolean isBadInput(String input) {
        if (input.contains(SAVE_SEP)) {
            ui.printMessage("'" + SAVE_SEP + "' is not allowed!");
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
                    ui.printMessage("OOPS!!! The description of a " + inputTxt + " cannot be empty.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    ui.printMessage("Invalid input");
                }
            } else {
                try {
                    processInput(inputTxt);
                } catch (DukeException e) {
                    ui.printMessage("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }

            writeToFile(FILE_PATH, generateFileOutput());

            ui.printMessage("Total tasks: " + tasks.size());
            inputTxt = userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

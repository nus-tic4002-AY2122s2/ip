package edu.nus.duke.command;

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
import edu.nus.duke.task.Task;
import edu.nus.duke.task.Todo;
import edu.nus.duke.task.Deadline;
import edu.nus.duke.task.Event;
import edu.nus.duke.exception.DukeException;

public class Duke {
    // Variables
    private static final String FILE_PATH = "data/duke.txt";
    private static final String SAVE_SEP = ";";
    private static final String HORIZ_LINE = "____________________________________________________________";
    private static final String CMD_TODO = "todo";
    private static final String CMD_DEADLINE = "deadline";
    private static final String CMD_EVENT = "event";
    private static ArrayList<Task> tasks = new ArrayList<>();

    // Methods
    private static void loadTask(String line) throws DukeException, ArrayIndexOutOfBoundsException {
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

    private static void loadData(File f) throws FileNotFoundException, DukeException {
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

    private static void initApp() throws FileNotFoundException, DukeException {
        File f = new File(FILE_PATH);
        if (f.isFile()) {
            loadData(f);
        }
        System.out.println("Hello! I'm Jarvis");
        System.out.println("What can I do for you?");
        System.out.println(HORIZ_LINE);
    }

    private static void finaliseApp() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(HORIZ_LINE);
    }

    private static void printList() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).getTask());
        }
    }

    private static String generateFileOutput() {
        StringBuilder output = new StringBuilder();
        for (Task task : tasks) {
            output.append(task.printToSave());
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    private static void createParentDir(String filePath) throws IOException {
        Path path = Paths.get(filePath).getParent();
        if (path == null || Files.isDirectory(path)) {
            return;
        }
        Files.createDirectory(path);
    }

    private static void writeToFile(String filePath, String txt) throws IOException {
        createParentDir(filePath);
        FileWriter fw = new FileWriter(filePath);
        fw.write(txt);
        fw.close();
    }

    private static boolean isAddTask(String inputTxt) {
        return (inputTxt.startsWith(CMD_TODO) || inputTxt.startsWith(CMD_DEADLINE) || inputTxt.startsWith(CMD_EVENT));
    }

    private static void addTask(Task task) {
        tasks.add(task);
        System.out.println("added: " + task.getTask());
    }

    private static void processTask(String inputTxt) throws DukeException, ArrayIndexOutOfBoundsException {
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

    private static void setDone(String inputTxt) throws IndexOutOfBoundsException {
        int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
        tasks.get(idx).setDone();
        System.out.println("Nice! I've marked this as done:");
        System.out.println(tasks.get(idx).getTask());
    }

    private static void deleteTask(String inputTxt) throws IndexOutOfBoundsException {
        int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
        String task = tasks.get(idx).getTask();
        tasks.remove(idx);
        System.out.println("Noted. I've removed this task:");
        System.out.println(task);
    }

    private static void processInput(String inputTxt) throws DukeException {
        if (inputTxt.equals("list")) {
            printList();
        } else if (inputTxt.startsWith("done")) {
            try {
                setDone(inputTxt);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid/missing index");
            }
        } else if (inputTxt.startsWith("delete")) {
            try {
                deleteTask(inputTxt);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid/missing index");
            }
        } else {
            throw new DukeException();
        }
    }

    private static boolean isBadInput(String input) {
        if (input.contains(SAVE_SEP)) {
            System.out.println("'" + SAVE_SEP + "' is not allowed!");
            System.out.println(HORIZ_LINE);
            return true;
        }
        return false;
    }

    private static void runApp() throws IOException {
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
                    System.out.println("OOPS!!! The description of a " + inputTxt + " cannot be empty.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input");
                }
            } else {
                try {
                    processInput(inputTxt);
                } catch (DukeException e) {
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }

            writeToFile(FILE_PATH, generateFileOutput());

            System.out.println("Total tasks: " + tasks.size());
            System.out.println(HORIZ_LINE);
            inputTxt = userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        try {
            initApp();
        } catch (FileNotFoundException e) {
            System.out.println(FILE_PATH + " not found!");
            return;
        } catch (DukeException e) {
            System.out.println("Bad data in " + FILE_PATH);
            return;
        }
        try {
            runApp();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }
        finaliseApp();
    }
}

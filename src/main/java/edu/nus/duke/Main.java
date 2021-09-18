package edu.nus.duke;

import java.util.Scanner;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.task.Todo;
import edu.nus.duke.task.Deadline;
import edu.nus.duke.task.Event;
import edu.nus.duke.exception.DukeException;

public class Main {
    // Variables
    private final String CMD_TODO = "todo";
    private final String CMD_DEADLINE = "deadline";
    private final String CMD_EVENT = "event";
    private TaskList taskList;
    private Storage storage;

    // Constructor
    public Main(String filePath) {
        taskList = new TaskList();
        storage = new Storage(filePath, taskList);

        Ui.printMessage("Hello! I'm Jarvis\nWhat can I do for you?");
        runApp();
        Ui.printMessage("Bye. Hope to see you again soon!");
    }

    // Methods
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
            Ui.printMessage("Here are the tasks in your list:", false);
            Ui.printMessage(taskList.printTasks(), false);
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
        if (input.contains(storage.getSaveSep())) {
            Ui.printMessage("'" + storage.getSaveSep() + "' is not allowed!");
            return true;
        }
        return false;
    }

    private void runApp() {
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

            storage.writeToFile(taskList.printForFile());

            inputTxt = userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        new Main("data/duke.txt");
    }
}

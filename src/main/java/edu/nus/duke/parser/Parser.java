package edu.nus.duke.parser;

import edu.nus.duke.ui.Ui;
import edu.nus.duke.storage.Storage;
import edu.nus.duke.task.TaskList;
import edu.nus.duke.task.Todo;
import edu.nus.duke.task.Deadline;
import edu.nus.duke.task.Event;
import edu.nus.duke.exception.DukeInvalidInputException;
import edu.nus.duke.exception.DukeEmptyArgsException;

public class Parser {
    // Methods
    private static void rejectBadInput(String input) throws DukeInvalidInputException {
        if (input.contains(Storage.getSaveSep())) {
            throw new DukeInvalidInputException();
        }
    }

    private static void parseInput_MultiArgs(String cmd, String args, TaskList taskList) throws ArrayIndexOutOfBoundsException {
        String[] argsArray;
        String taskName;
        int idx;
        switch (cmd) {
        case "todo":
            taskName = args;
            taskList.addTask(new Todo(taskName));
            break;
        case "deadline":
            argsArray = args.split("/by");
            taskName = argsArray[0].trim();
            String by = argsArray[1].trim();
            taskList.addTask(new Deadline(taskName, by));
            break;
        case "event":
            argsArray = args.split("/at");
            taskName = argsArray[0].trim();
            String at = argsArray[1].trim();
            taskList.addTask(new Event(taskName, at));
            break;
        case "done":
            idx = Integer.parseInt(args) - 1;
            taskList.doneTask(idx);
            break;
        case "delete":
            idx = Integer.parseInt(args) - 1;
            taskList.deleteTask(idx);
            break;
        default:
            Ui.printMessage("OOPS!!! I'm sorry, but I don't know what that means :-(");
            break;
        }
    }

    public static void parseInput(String inputTxt, TaskList taskList) {
        try {
            rejectBadInput(inputTxt);

            String[] inputArray = inputTxt.split(" ", 2);
            String cmd = inputArray[0];

            if (cmd.equals("list")) {
                Ui.printMessage("Here are the tasks in your list:", false);
                Ui.printMessage(taskList.printTasks(), false);
                Ui.printMessage("Total tasks: " + taskList.getListSize());
            } else {
                if (inputArray.length == 1) {
                    throw new DukeEmptyArgsException();
                }
                String args = inputArray[1];
                parseInput_MultiArgs(cmd, args, taskList);
            }
        } catch (DukeInvalidInputException e) {
            Ui.printMessage("'" + Storage.getSaveSep() + "' is not allowed!");
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printMessage("Invalid input");
        } catch (DukeEmptyArgsException e) {
            Ui.printMessage("OOPS!!! The description of a " + inputTxt + " cannot be empty.");
        }
    }

    public static boolean isExit(String inputTxt) {
        return inputTxt.equals("bye");
    }
}

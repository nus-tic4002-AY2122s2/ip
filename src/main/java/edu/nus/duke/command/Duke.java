package edu.nus.duke.command;

import java.util.Scanner;
import edu.nus.duke.task.Task;
import edu.nus.duke.task.Todo;
import edu.nus.duke.task.Deadline;
import edu.nus.duke.task.Event;
import edu.nus.duke.exception.DukeException;

public class Duke {
    // Variables
    static final String HORIZ_LINE = "____________________________________________________________";
    static final String CMD_TODO = "todo";
    static final String CMD_DEADLINE = "deadline";
    static final String CMD_EVENT = "event";
    static Task[] tasks = new Task[100];

    // Methods
    private static void initApp() {
        System.out.println("Hello! I'm Jarvis");
        System.out.println("What can I do for you?");
        System.out.println(HORIZ_LINE);
    }

    private static void finaliseApp() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(HORIZ_LINE);
    }

    private static void printList(int lastIndex) {
        System.out.println("Here are the tasks in your list:");
        for (int j = 0; j < lastIndex; j++) {
            System.out.println((j + 1) + ". " + tasks[j].getTask());
        }
    }

    private static boolean isAddTask(String inputTxt) {
        return (inputTxt.startsWith(CMD_TODO) || inputTxt.startsWith(CMD_DEADLINE) || inputTxt.startsWith(CMD_EVENT));
    }

    private static void addTask(String inputTxt, int lastIndex) throws DukeException, ArrayIndexOutOfBoundsException {
        if (inputTxt.split(" ").length == 1) {
            throw new DukeException();
        }

        if (inputTxt.startsWith(CMD_TODO)) {
            tasks[lastIndex] = new Todo(inputTxt.substring(5));
        } else if (inputTxt.startsWith(CMD_DEADLINE)) {
            String[] deadlineSplit = inputTxt.substring(9).split("/by");
            tasks[lastIndex] = new Deadline(deadlineSplit[0].trim(), deadlineSplit[1].trim());
        } else if (inputTxt.startsWith(CMD_EVENT)) {
            String[] eventSplit = inputTxt.substring(6).split("/at");
            tasks[lastIndex] = new Event(eventSplit[0].trim(), eventSplit[1].trim());
        }
        System.out.println("added: " + tasks[lastIndex].getTask());
    }

    private static void setDone(String inputTxt) throws ArrayIndexOutOfBoundsException, DukeException {
        int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
        if (tasks[idx] == null) {
            throw new DukeException();
        }
        tasks[idx].setDone();
        System.out.println("Nice! I've marked this as done:");
        System.out.println(tasks[idx].getTask());
    }

    private static void processInput(String inputTxt, int lastIndex) throws DukeException {
        if (inputTxt.equals("list")) {
            printList(lastIndex);
        } else if (inputTxt.startsWith("done")) {
            try {
                setDone(inputTxt);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid/missing index");
            } catch (DukeException e) {
                System.out.println("Invalid/missing index");
            }
        } else {
            throw new DukeException();
        }
    }

    private static void runApp() {
        Scanner userInput = new Scanner(System.in);
        String inputTxt = userInput.nextLine();
        for (int i = 0; i < tasks.length;) {
            if (inputTxt.equals("bye")) {
                break;
            }

            if (isAddTask(inputTxt)) {
                try {
                    addTask(inputTxt, i);
                    i++;
                } catch (DukeException e) {
                    System.out.println("OOPS!!! The description of a " + inputTxt + " cannot be empty.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input");
                }
            } else {
                try {
                    processInput(inputTxt, i);
                } catch (DukeException e) {
                    System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }

            System.out.println("Total tasks: " + i);
            System.out.println(HORIZ_LINE);

            inputTxt = userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        initApp();
        runApp();
        finaliseApp();
    }
}

import tasklist.Task;
import java.util.ArrayList;

public class UI {
    public static void printDuke() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.print("Hello! I'm Duke\n" + "What can I do for you?\n");
    }

    public static void bye() {
        UI.printLine();
        UI.addSpaces("%sBye. Hope to see you again soon!",5);
        UI.printLine();
    }

    public static void printLine() {
        UI.addSpaces("%s____________________________________________________________",4);
    }

    public static void printAddedTask(ArrayList<Task> taskList) {
        UI.addSpaces("%s" + taskList.get(taskList.size() - 1).toString(),6);
    }

    public static void printTask(ArrayList<Task> taskList) {
        UI.printLine();
        UI.addSpaces("%sGot it. I've added this task:",5);
        printAddedTask(taskList);
        printNumberOfTasks(taskList);
        UI.printLine();
    }

    public static void printOutput(ArrayList<Task> taskList) {
        UI.printLine();
        UI.addSpaces("%sHere are the tasks in your list:",5);
        for (int i = 0; i < taskList.size(); i++) {
            UI.addSpaces("%s" + (i + 1) + ". " + taskList.get(i).toString(),5);
        }
        UI.printLine();
    }

    public static void printListEmpty() {
        UI.printLine();
        UI.addSpaces("%sList is empty!",5);
        UI.printLine();
    }

    public static void printNumberOfTasks( ArrayList<Task> taskList) {
        UI.addSpaces("%sNow you have " + (taskList.size()) + " tasks in the list.",5);
    }

    public static void printMarkedAsDone() {
        UI.addSpaces( "%sNice! I've marked this task(s) as done:",5);
    }

    public static void printRemoveTask() {
        UI.addSpaces( "%sNoted. I've removed this task:",5);
    }

    public static void printTaskSaved() {
        UI.printLine();
        UI.addSpaces("%sTasks saved!",5);
        UI.printLine();
    }

    public static void addSpaces(String text, Integer value) {
        System.out.printf((text) + "%n", " ".repeat(value));
    }

    public static void printParseException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! Please enter DD MMM YYYY date format.",5);
        UI.printLine();
    }

    public static void printEmptyException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! The description cannot be empty.",5);
        UI.printLine();
    }

    public static void printStringFormatException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! I'm sorry, but I don't know what that means :-(",5);
        UI.printLine();
    }

    public static void printEmptyToDoDescriptionException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! The description of a todo cannot be empty.",5);
        UI.printLine();
    }

    public static void printEmptyEventDescriptionException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! The description of a event cannot be empty.",5);
        UI.printLine();
    }

    public static void printEmptyDeadlineDescriptionException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! The description of a deadline cannot be empty.",5);
        UI.printLine();
    }

    public static void printNumberFormatException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! I'm sorry, but I don't know what that means :-(",5);
        UI.printLine();
    }

    public static void printIndexOutOfRangeException() {
        UI.printLine();
        UI.addSpaces("%s☹ OOPS!!! Out of Range!",5);
        UI.printLine();
    }

}
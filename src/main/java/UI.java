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

    public static void printTask(ArrayList<Task> taskList) {
        UI.printLine();
        UI.addSpaces("%sadded: " + taskList.get(taskList.size() - 1).toString(),5);
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

    public static void printMarkedAsDone(Task t) {
        UI.printLine();
        UI.addSpaces( "%sNice! I've marked this task(s) as done:",5);
        UI.addSpaces("%s" + t.toString(),7);
        UI.printLine();
    }

    public static void addSpaces(String text, Integer value) {
        System.out.printf((text) + "%n", " ".repeat(value));
    }
}

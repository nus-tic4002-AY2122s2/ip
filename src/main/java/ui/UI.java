package ui;

import tasklist.Task;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Scanner input;

    public UI() {
        input = new Scanner(System.in);

    }
    public static String welcomeDuke() {
        String message = "";
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        message += "Hello from\n" + logo;
        message +="Hello! I'm Duke\n" + "What can I do for you?\n";
        return message;
    }

    public static String bye() {
        return ("Bye. Hope to see you again soon!");
    }

    public static String addedTask(ArrayList<Task> taskList) {
        String taskName = taskList.get(taskList.size() - 1).toString();
        return taskName;
    }

    public static String taskAddedDetails(ArrayList<Task> taskList) {
        String message="";

        message += "Got it. I've added this task: \n";
        message += addedTask(taskList) + "\n";
        message += numberOfTasks(taskList) + "\n";

        return message;

    }

    public static String taskListDetails(ArrayList<Task> taskList) {
        String message = "";
        message += "Here are the tasks in your list: \n";
        for (int i = 0; i < taskList.size(); i++) {
            message += (i + 1) + ". " + taskList.get(i).toString() + "\n";
        }
        return message;
    }

    public static String listEmpty() {
        return "List is empty!";
    }

    public static String numberOfTasks( ArrayList<Task> taskList) {
        return "Now you have " + (taskList.size()) + " tasks in the list.";
    }

    public static String markedAsDone() {
        return "Nice! I've marked this task(s) as done: \n";
    }

    public static String removedTask() {
        return "Noted. I've removed this task: \n";
    }

    public static String taskSaved() {
        return "Tasks saved!";
    }

    public static String parseException() {
        return "OOPS!!! Please enter DD MMM YYYY date format.";
    }

    public static String emptyException() {
        return "OOPS!!! The description cannot be empty.";
    }

    public static String stringFormatException() {
        return "OOPS!!! I'm sorry, but I don't know what that means.";
    }

    public static String emptyToDoDescriptionException() {
        return "OOPS!!! The description of a todo cannot be empty.";
    }

    public static String emptyEventDescriptionException() {
        return "OOPS!!! The description of a event cannot be empty.";
    }

    public static String emptyDeadlineDescriptionException() {
        return "OOPS!!! The description of a deadline cannot be empty.";
    }

    public static String numberFormatException() {
        return "OOPS!!! I'm sorry, but I don't know what that means.";
    }

    public static String indexOutOfRangeException() {
        return "OOPS!!! Out of Range!";
    }

}
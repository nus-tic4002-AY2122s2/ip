package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Stores the message to interact with user.
 * */
public class UI {
    /**
     * Returns welcome message of duke.
     * */
    public static String welcome() {
        //String logo = " ____        _        \n"
        //        + "|  _ \\ _   _| | _____ \n"
        //        + "| | | | | | | |/ / _ \\\n"
        //        + "| |_| | |_| |   <  __/\n"
        //        + "|____/ \\__,_|_|\\_\\___|\n";

        return "Hello, I'm Duke.\n"
                + "What can I do for you?";
    }

    /**
     * Returns add message of duke.
     * @param task task to print after adding to list.
     * @param size size of task list.
     * */
    public static String addMessage(Task task, int size) {
        return "Got it. I've added this task:\n"
                + "  " + task.toString() + "\n"
                + "Now you have " + size + " tasks in the list.";
    }

    /**
     * Returns list message of task list.
     * @param tasks task list for printing.
     * */
    public static String listMessage(ArrayList<Task> tasks) {
        String message = "Here are the tasks in your list:";
        for (int i = 0; i < tasks.size(); i++) {
            message = message + "\n" + (i + 1) + "." + tasks.get(i).toString();
        }
        return message;
    }

    /**
     * Returns done message of duke.
     * @param tasks task list.
     * @param index index of task in task list which will be marked as done.
     * */
    public static String doneMessage(ArrayList<Task> tasks, int index) {
        return "Nice! I've marked this task as done:\n"
                + "  " + tasks.get(index).toString();
    }

    /**
     * Returns delete message of duke.
     * @param task task deleted.
     * @param size number of the tasks remained.
     * */
    public static String deleteMessage(Task task, int size) {
        return "Noted. I've removed this task:\n"
                + "  "  + task.toString() + "\n"
                + "Now you have " + size + " tasks in the list.";
    }

    /**
     * Returns find message of duke.
     * @param tasks task list.
     * @param findResult list stores all the indexes of matched tasks.
     * */
    public static String findMessage(ArrayList<Task> tasks, ArrayList<Integer> findResult) {
        if (findResult.size() == 0) {
            return "Oops!!! None of task can be found";
        } else {
            String message = "Here are the matching tasks in your list:";
            for (int index : findResult) {
                message = message + "\n" + (index + 1) + "." + tasks.get(index).toString();
            }
            return message;
        }
    }

    /**
     * Returns edit message of duke.
     * @param tasks task list.
     * @param index index of task in task list which is edited.
     * */
    public static String editMessage(ArrayList<Task> tasks, int index) {
        return "Noted. I've edited this item:\n"
                + (index + 1) + "." + tasks.get(index).toString();
    }

    /**
     * Returns bye message of duke.
     * */
    public static String byeMessage() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Prints out split line.
     * */
    public static void splitLine() {
        System.out.println("--------------------------------------------------------");
    }

    /**
     * Scan and reads the input of user.
     * @return user full command in string.
     * */
    public static String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

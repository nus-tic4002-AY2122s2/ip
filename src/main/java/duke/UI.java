package duke;

import duke.task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static void welcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|";
        System.out.println("Hello from\n" + logo);
        splitLine();
        System.out.println("Hello! I'm duke.Duke");
        System.out.println("What can I do for you?");
        splitLine();
    }

    public static void addMessage(Task task, int size) {
        System.out.println("Got it. I've added this task: ");
        System.out.println("  " + task.toString());
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public static void listMessage(ArrayList<Task> tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + "." + tasks.get(i).toString());
        }
    }

    public static void doneMessage(ArrayList<Task> tasks, int index) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println("  " + tasks.get(index).toString());
    }

    public static void deleteMessage(Task task, int size) {
        System.out.println("Noted. I've removed this task: ");
        System.out.println("  "  + task);
        System.out.println("Now you have " + size + " tasks in the list.");
    }

    public static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void splitLine() {
        System.out.println("--------------------------------------------------------");
    }

    public static String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

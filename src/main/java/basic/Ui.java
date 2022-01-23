package basic;

import task.Task;

import java.util.Scanner;

/**
 * Text UI of the application.
 */
public class Ui {
    private void showLine() {
        System.out.println("___________________________________________");
    }

    /**
     * Generates and prints the welcome message upon the start of the application.
     */
    void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hellooooooo from\n" + logo);
        showLine();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        showLine();
    }

    /**
     * Prompts for the command and reads the text entered by the user.
     *
     * @return command (full line) entered by the user
     */
    String readCommand() {
        Scanner input = new Scanner(System.in);
        String myString = "";
        myString += input.nextLine();
        return myString;
    }

    /**
     * Displays the response when the program is exited.
    */
    public void showBye() {
        System.out.println("   Bye. Hope to see you again soon!");
        showLine();
    }

    /**
     * Displays the response when a task is marked as done.
    */
    public void showDone() {
        System.out.print("   " + "Nice! I've marked this task as done: \n" + "   ");
    }

    /**
     * Displays an empty line.
    */
    public void printEmptyLine() {
        System.out.println("\n");
    }

    /**
     * Displays the response when a task is added.
    */
    public void showAdded() {
        System.out.print("   " + "Got it. I've added this task:\n" + "   ");
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public void printTasks(TaskList tasks) {
        for (int j = 1; j <= tasks.sizeOfTask(); j++) {
            System.out.print("   " + j + ".");
            System.out.println(tasks.returnTask(j - 1));
        }
    }

    /**
     * Shows a list of tasks to the user, formatted as an indexed list.
     */
    public void printMatchingTask(Task tasks, int index) {
        System.out.print("   " + index + ".");
        System.out.println(tasks.toString());
    }

    /**
     * Displays a task.
    */
    public void printTask(Task task) {
        System.out.println(task);
    }

    /**
     * Displays a number of tasks in the Tasklist.
    */
    public void printTaskNum(TaskList tasks, Task task) {
        System.out.println(task + "\n   Now you have " + tasks.sizeOfTask() + " tasks in the list.\n");
    }

    /**
     * Displays the response when a task is deleted.
    */
    public void printDeleteCommand(Task task, int num) {
        System.out.println("   Noted. I've removed this task:\n   " + task + "\n   Now you have " 
                + num + " tasks in the list.");
    }

    /**
     * Displays the header of response when a find command is entered.
    */
    public void printMatching() {
        System.out.println("   Here are the matching tasks in your list:");
    }

    /**
     * Displays the exception message.
    */
    void printException(Exception e) {
        System.out.println(e.toString());
        printEmptyLine();
    }
}

package duke.ui;

import duke.task.Task;

import java.util.Scanner;

public class Ui {

    /**
     * Welcome message to show to the user when starting up Duke
     */
    public static void showDukeWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo +
                "What can I do for you?\n");
        showLine();
    }

    /**
     * Line separator to spilt between user input and system output
     */
    public static void showLine(){
        System.out.println("____________________________________________________________");
    }

    /**
     * Display the exit message to let user know that the program will end.
     */
    public static void showExit(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static String readCommand(){
        String line;
        Scanner in = new Scanner(System.in);
        System.out.print("Type something: ");
        line = in.nextLine();
        return line;
    }

    /**
     * Display the whole list of task to the user
     * @param task the task list
     */
    public static void showTaskInfo(Task task){
        System.out.println("Task Number " + (task.getTaskIndex() +1) + ": " + task.toString());
    }

    /**
     * Display the message of no matches
     */
    public static void showNoMatchFound(){
        System.out.println("We couldn't find any matches.");
    }



    /**
     * Display to the user that the task he requested has been deleted
     * @param deletedTask The task that the user request to be deleted
     * @param numberOfTask The total number of task remaining in the list
     */
    public static void displayDeleteMsg(String deletedTask, int numberOfTask){
        System.out.println("I have deleted the following: \n" +
                deletedTask + "\n" +
                "Now you have "+ numberOfTask +" tasks in the list.");
    }

    /**
     * Display to the user that task has been marked done
     * @param doneTask The task that the user request to be marked done
     * @param taskIndex The index/id of the task
     */
    public static void doneMsg(String doneTask, int taskIndex){
        System.out.println("Nice! I've marked this task as done: \n" +
                "Task Number "+ taskIndex + ": " + doneTask);
    }


    public static void displayAddMessage(String thatTask, int numberOfTask){
        System.out.println("Added: "+ thatTask + "\n" +
                "Now you have "+ numberOfTask +" tasks in the list.");
    }

    /**
     * Display the error message to user
     * @param errorMessage Error message from expected DukeException
     */
    public static void showError(String errorMessage){
        System.out.println("WE GOT AN ERROR: " + errorMessage);
    }

    /**
     * Show the error to the user when there is a problem with starting up the program
     */
    public static void showLoadingError(){
        System.out.println("There are currently problem with loading the task, proceeding to create a new empty list");
    }




}

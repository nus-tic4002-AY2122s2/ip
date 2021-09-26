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

    /**
     * Display any message to he user
     * @param msg the message to be display to the user
     */
    public static void displayMsg(String msg){
        System.out.println(msg);
    }

    /**
     * Display all the command available and how to use them
     */
    public static void displayListOfHelpFunction(){
        System.out.println("List of command that DUKE have: \n" +
                "(*Command are not case sensitive)\n" +
                "(**Words with double * are case sensitive)\n");
        System.out.println("\"Hi\": Say hello to the bot\n" +
                "How to use: \n" +
                "Type Hi\n" +
                "E.g. Type something: Hi\n");
        System.out.println("\"Bye\" OR \"Exit\" OR \"Quit\": Say goodbye to the bot and close the program\n" +
                "How to use: \n" +
                "Type Bye\n" +
                "E.g. Type something: Bye\n");
        System.out.println("\"Todo\": Set a task that you want to do\n" +
                "How to use: \n" +
                "Type Todo (Your To Do Task)\n" +
                "E.g. Type something: Todo Get a pet\n");
        System.out.println("\"Event\": Set a event task\n" +
                "How to use: \n" +
                "Type Event (Your event Task) /at (YYYY-MM-DD OR Monday-Sunday(Full spelling or First 3 letter)) (Optional: hh:mm OR hhmm <24 Hours format>) \n" +
                "E.g. Type something: Event Countdown party /at 2019/12/31\n" +
                "Type something: Event Basketball /at Wed 18:00 \n");
        System.out.println("\"Deadline\": Set a deadline task\n" +
                "How to use: \n" +
                "Type Deadline (Your event Task) /by (YYYY-MM-DD OR Monday-Sunday(Full spelling or First 3 letter)) (Optional: hh:mm OR hhmm <24 Hours format>)\n" +
                "E.g. Type something: Deadline Duke project /by 2019/11/17 2359 \n" +
                "Type something: Deadline Pay phone bills /by Sat\n");
        System.out.println("\"List\": Bring out the list of task\n" +
                "How to use: \n" +
                "Type List\n" +
                "E.g. Type something: list\n");
        System.out.println("\"Find\": Find a task with the word you want to find\n" +
                "How to use: \n" +
                "Type Find (The word**)\n" +
                "E.g. Type something: Find bill\n");
        System.out.println("\"Done\": Set a task to Done\n" +
                "How to use: \n" +
                "Type Done (Task Number)\n" +
                "E.g. Type something: Done 5\n");
        System.out.println("\"Delete\": Delete a task(Be careful: Once you delete a task, it is gone forever. And all other task number changes) \n" +
                "How to use: \n" +
                "Type Delete (Task Number)\n" +
                "E.g. Type something: Delete 5\n");
        System.out.println("\"Clearlist\": Clear and remove all the task in the task list\n" +
                "*Note: Clearlist will not save until you add another task, so if you want to undo your clear, restart the program\n" +
                "How to use: \n" +
                "Type Clearlist\n" +
                "E.g. Type something: Clearlist\n");
        System.out.println("\"Help\": Since you just used this, I'm sure I don't have to explain this...\n");
    }

}

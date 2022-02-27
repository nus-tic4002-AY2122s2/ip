package Ui;

import Tasks.Task;
import TaskList.*;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import Parser.*;

public class Ui {
    private static final String line = "    ____________________________________________________________";
    /**
     * Prints welcome message of duke.
     * */
    public static void Greet(){
//        String line = ;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLines(line);
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        printLines(line);

    }

    public static String welcome(){
//        String line = ;

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLines(line);
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        printLines(line);
        return line + logo + "     Hello! I'm Duke" + "     What can I do for you?" + line;
    }

    public String userInput;
    public Scanner scan = new Scanner( System.in ); // To getting userinput


    /**
     * to Read user input
     */
    public String readCommand(){
        userInput = scan.nextLine();
        return userInput;
    }

    /**
     *
     * @param insert
     * @param tasklist
     */
    public void newTask(Task insert, TaskList tasklist){
        printLines(line);
        System.out.println("      Got it. I've added this task:");
        System.out.println("       " + insert.toString());
        System.out.println("     Now you have " +  Integer.toString(tasklist.getSize()) +  "");
        printLines(line);
//        return line + "\n" + "      Got it. I've added this task:\n" + "       " + insert.toString() + "\n" + "     Now you have " + Integer.toString(tasklist.getSize()) + " tasks in the list.\n" + line;
    }

    /**
     * prints the Todo Messages
     * @param tasklist
     */
    public void newTodo(TaskList tasklist){
        String message = "";
        printLine();
        System.out.println("      Got it. I've added this task:");
        System.out.println("     " + tasklist.getTask(tasklist.getSize()-1).getDescription());
        printLine();
        message += line + "\n";
        message += "      Got it. I've added this task:\n";
        message += "     " + tasklist.getTask(tasklist.getSize()-1).getDescription() + "\n";
//        return message;
    }

    /**
     * prints the Done Messages
     */
    public void newDone(){
        String msg = "";
        printLine();
        System.out.println("     Nice! I've marked this task as done:");
        msg += line + "\n";
        msg += "     Nice! I've marked this task as done:\n";
//        return msg;
    }

    /**
     * Show goodbye message
     */
    public void showGoodBye(){
        System.out.println(userInput);
        printLine();
        System.out.println("     Bye. Hope to see you again soon!");
        printLine();
        String msg = "";
        msg += line + "\n";
        msg += "     Bye. Hope to see you again soon!\n";
        msg += line + "\n";
//        return msg;
    }


    // Error section

    /**
     * Return Loading error message
     */
    public void showLoadingError(){
        System.out.println(" :(  Loading Error!");
    }



    /**
     * Return error message for Wrong Date Input
     */
    public void showInvalidDateException(){
        Line();
        System.out.println("     ☹ OOPS!!! Date, Syntax Wrong, Please use : DD-MMMM-YYYY(13-Oct-2019) HHmm (1000)");
        Line();
    }

    /**
     * Return error message for file error
     */
    public void showIOException(){
        Line();
        System.out.println("File error ...");
        Line();
    }

    //Displaying Task class list
    public void displayTaskList(String input,TaskList tasklist) throws UnsupportedEncodingException {
        System.out.println(input);
        printLines(line);
        System.out.println("     Here are the tasks in your list:");
        for(int i = 0; i < tasklist.getSize(); i++){
            int idx = i+1;
            PrintStream out = new PrintStream(System.out, true, "UTF-8");
            System.out.println("     "+ idx + ". " + tasklist.getTask(i).toString() );
        }
        printLines(line);
    }



    /**
     * Return UI of lines when invoked
     */
    public static void printLines(String k){
        System.out.println(k);
    }

    public static void printLine(){
        System.out.println(line);
    }

    public void Line(){
        System.out.println(line);
    }

    public String getLine(){
        return line;
    }

}
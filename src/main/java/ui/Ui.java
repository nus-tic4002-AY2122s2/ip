package ui;

import java.util.ArrayList;

/**
 * Ui class is only for printing message.
 */
public class Ui {
    private static String indentation = "          ";

    public static  void  welcome () {
        print("Hello! I'm Duke\n" +  indentation + "can I do for you?");
    }

    public static void bye () {
        print("Bye. Hope to see you again soon!");
    }

    public static  void printTask(String message, int noTask) {
        printLine();
        System.out.println(indentation + "Got it. I've added this task:");
        System.out.println(indentation + message);
        System.out.println(indentation + "Now you have " + noTask + " tasks in the list.");
        printLine();
    }

    public static void print(String message) {
        printLine();
        System.out.println(indentation + message);
        printLine();
    }
    
    public static void printList(ArrayList<String> list) {
        int index = 1;
        printLine();
        System.out.println(indentation + "Here are the tasks in your list:");
        for (String listItem : list) {
            System.out.println(indentation + index + ". " + listItem);
            index +=1;
        }
        printLine();
    }

    public static void printMarkedDone(String message){
        printLine();
         System.out.println("      " + "Nice! I've marked this task as done:");
        System.out.println(indentation + message);
        printLine();
    }

    private static void printLine() {
        System.out.println("     ____________________________________________________________");
    }
}

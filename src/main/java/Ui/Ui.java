package Ui;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ui {
    private static String indentation = "          ";

    public static  void  welcome () {
        print("Hello! I'm Duke\n" +  indentation + "can I do for you?");
    }

    public static void bye () {
        print("Bye. Hope to see you again soon!");
    }

    public static void print(String message) {
        printLine();
        System.out.println(indentation + message);
        printLine();
    }
    
    public static void printList(ArrayList<String> list) {
        int index = 1;
        printLine();

        for (String listItem : list) {
            System.out.println(indentation + index + ". " + listItem);
            index +=1;
        }

        printLine();
    }

    public static void printMarkedDone(String message){
        printLine();
        System.out.println("      " + "Nice! I've marked this task as done: ");
        System.out.println(indentation + message);
        printLine();
    }

    private static void printLine() {
        System.out.println("     ____________________________________________________________");
    }
}

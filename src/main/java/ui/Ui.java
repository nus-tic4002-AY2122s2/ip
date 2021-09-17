package ui;

import task_classes.Task;

import java.util.Scanner;

public class Ui {

    public Ui (){}

    /**
     * The greeting with some instruction
     */
    public void showGreetingMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Output_On_Screen.toPrintSeparateLine();
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        Output_On_Screen.toPrintSeparateLine();
        System.out.println("");
    }

    public void showLoadingError(){
        ErrorMessage.showLoadingError();
    }

    /**
     * Print out Separated_Line onto screen
     */
    public static void toPrintSeparateLine(){
        System.out.print("    ");
        for(int i=0; i<100; i++){
            System.out.print("_");
        }
        System.out.println("");
    }


    public String readCommand(){
        String input;
        Scanner in = new Scanner(System.in);
        return input = in.nextLine();
    }

    public static void toPrintTaskDeletedMessage(Task deletedTask, int taskListRemainingSize) {
        TaskDeletedMessage taskDeletedMessage = new TaskDeletedMessage(deletedTask, taskListRemainingSize);
        taskDeletedMessage.printTaskDeletedMessage();
    }
}

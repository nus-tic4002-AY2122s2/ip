package ui;

import parser.Parser;
import task_classes.Deadline;
import task_classes.Event;
import task_classes.Task;
import task_classes.Todo;

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

        toPrintSeparateLine();
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        toPrintSeparateLine();
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

    /**
     * Output after add Todo task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Todo
     * @param listQty the total quantity of task in the List after added current new task
     */
    public static void printTodoAddedOutput(Todo newTask, int listQty){
        System.out.println("     Got it. I've added this task:");
        System.out.println("        [" + newTask.getType() + "][" + newTask.getStatusIcon() + "] " + newTask.getDescription());
        System.out.println("     Now you have " + listQty + " tasks in the list.");
    }

    /**
     * Output after add Deadline task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Deadline
     * @param listQty the total quantity of task in the List after added current new task
     */
    public static void printDeadlineAddedOutput(Deadline newTask, int listQty){
        System.out.println("     Got it. I've added this task:");
        System.out.print("        [" + newTask.getType() + "][" + newTask.getStatusIcon() + "] " + newTask.getDescription());

        System.out.println(" (by: " + newTask.getBy() + ")");
        System.out.println("     Now you have " + listQty + " tasks in the list.");
    }

    /**
     * Output after add Event task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Event
     * @param listQty the total quantity of task in the List after added current new task
     */
    public static void printEventAddedOutput(Event newTask, int listQty){
        System.out.println("     Got it. I've added this task:");
        System.out.print("        [" + newTask.getType() + "][" + newTask.getStatusIcon() + "] " + newTask.getDescription());

        System.out.println(" (by: " + newTask.getAt() + ")");
        System.out.println("     Now you have " + listQty + " tasks in the list.");
    }

    /**
     * Goodbye Output
     */
    public static void printGoodbyeOutput(){
        System.out.println("     Bye. Hope to see you again soon!");
    }

    /**
     * Output after mark particular task status as done
     *
     * @param task The Task which marked as done
     */
    public static void printMarkAsDoneOutput(Task task){

        String taskType = task.getType();
        System.out.println("     Nice! I've marked this task as done:");
        System.out.print("       [" +
                task.getType() + "][" +
                task.getStatusIcon() + "] " + task.getDescription());

        switch (taskType){
            case "E":
                String eventDateTime = task.getAt();
                System.out.println(" (at: " + eventDateTime + ")");

                break;
            case "D":
                String deadlineDateTime = task.getBy();
                System.out.println(" (by: " + deadlineDateTime + ")");

                break;
            default:
                System.out.println("");
        }
    }

//    public static void printDateTimeFormatSuggestion() {
//        String dateType;
//
//        System.out.println("     Please choose the Date format:");
//        System.out.println("       1. MMM D YYY\n" +
//                "       2. Day of Month Year");
//
//        Scanner date_choice = new Scanner(System.in);
//        dateType = date_choice.nextLine();
//
//        if(!dateType.equals("1") && !dateType.equals("2")){
//            Ui.toPrintSeparateLine();
//            System.out.println("     The Date choice you choose is invalid. Please try again.");
//            Ui.toPrintSeparateLine();
//            return Ui.printDateTimeFormatSuggestion();
//        }
//        else {
//            return dateType;
//        }
//    }
}

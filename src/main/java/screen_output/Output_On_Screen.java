package screen_output;


import task_classes.Deadline;
import task_classes.Event;
import task_classes.Task;
import task_classes.Todo;

import java.util.Vector;

public class Output_On_Screen {

    /**
     * The greeting with some instruction
     */
    public static void greetingOutput() {
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        //System.out.println("     **Date and time input format: /by(at): **");
        //System.out.println("     **1. Deadline: YYYY-MM-DD Hour(0-23):Minute(0-59)**");
        //System.out.println("     **2. YYYY-MM-DD Hour(0-23):Minute(0-59) -> Hour(0-23):Minutes(0-59)**");
        //System.out.println("     **3. YYYY-MM-DD Hour(0-23):Minute(0-59) -> YYYY-MM-DD Hour(0-23):Minute(0-59)**");
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

    /**
     * Goodbye Output
     */
    public static void printGoodbyeOutput(){
        System.out.println("     Bye. Hope to see you again soon!");
        toPrintSeparateLine();
        System.out.println("");
    }

    /**
     * Output after mark particular task status as done
     *
     * @param list The entire Task List
     * @param n is the Task Sequence number in the Task List
     */
    public static void printMarkAsDoneOutput(Vector<Task> list, int n, String taskType){

        System.out.println("     Nice! I've marked this task as done:");
        System.out.print("       [" +
                list.get(n).getType() + "][" +
                list.get(n).getStatusIcon() + "] " + list.get(n).getDescription());

        switch (taskType){
            case "E":
                String eventDateTime = list.get(n).getAt();
                System.out.println(" (at: " + eventDateTime + ")");

                break;
            case "D":
                String deadlineDateTime = list.get(n).getBy();
                System.out.println(" (by: " + deadlineDateTime + ")");

                break;
            default:
                System.out.println("");
        }

        toPrintSeparateLine();
        System.out.println("");
    }

    /**
     * Print the list onto screen
     *
     * @param list The entire Task List
     */
    public static void printOutList(Vector<Task> list){
        System.out.println("     Here are the task(s) in your list:");
        for (int i = 0; i < list.size(); i++) {
            int j = i + 1;
            System.out.print("     " + j + "." +
                    "[" + list.get(i).getType() + "]" +
                    "[" + list.get(i).getStatusIcon() + "] " + list.get(i).getDescription());

            String taskType = list.get(i).getType();

            switch(taskType){
                case "E":
                    Task currentTask = list.get(i);
                    String eventDateTime = currentTask.getAt();
                    System.out.println(" (at: " + eventDateTime + ")");

                    break;
                case "D":
                    Task currentDeadlineTask = list.get(i);
                    String deadlineDateTime = currentDeadlineTask.getBy();
                    System.out.println(" (by: " + deadlineDateTime + ")");

                    break;
                default:
                    System.out.println("");
            }
        }

        Output_On_Screen.toPrintSeparateLine();
        System.out.println("");
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
        toPrintSeparateLine();
        System.out.println("");
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
        toPrintSeparateLine();
        System.out.println("");
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
        toPrintSeparateLine();
        System.out.println("");
    }

    /**
     * To print message when user input an invalid input
     */
    public static void toPrintNotUnderstandableInputMessage(){
        System.out.println("    Invalid Input! Please try again!");
        toPrintSeparateLine();
        System.out.println("");
    }

    /**
     * To print message after user deleted a deadline task successfully
     *
     * @param List the overall task list
     * @param deletedTask the task be deleted by user
     */
    public static void printDeletedDeadline(Vector<Task> List, Task deletedTask){

        String taskDescription = deletedTask.getDescription();
        String taskType = deletedTask.getType();
        String taskStatus = deletedTask.getStatusIcon();
        String dateTime = deletedTask.getBy();

        int taskQuantity = List.size();

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "][" + taskStatus + "] " + taskDescription + "(by: " + dateTime + ")");
        System.out.println("     Now you have " + taskQuantity + " task(s) in the list.");

        toPrintSeparateLine();
        System.out.println("");
    }

    /**
     * To print message after user deleted a event task successfully
     *
     * @param List the list which store all the task
     * @param deletedTask the deleted task by user
     */
    public static void printDeletedEvent(Vector<Task> List, Task deletedTask){

        String taskDescription = deletedTask.getDescription();
        String taskType = deletedTask.getType();
        String taskStatus = deletedTask.getStatusIcon();
        String dateTime = deletedTask.getAt();

        int taskQuantity = List.size();

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "][" + taskStatus + "] " + taskDescription + "(at: " + dateTime + ")");
        System.out.println("     Now you have " + taskQuantity + " task(s) in the list.");

        toPrintSeparateLine();
        System.out.println("");
    }

    /**
     * To print message after user deleted a todo task successfully
     * @param List the list which store all the task
     * @param deletedTask the deleted task by user
     */
    public static void printDeletedTodo(Vector<Task> List, Task deletedTask){

        String taskDescription = deletedTask.getDescription();
        String taskType = deletedTask.getType();
        String taskStatus = deletedTask.getStatusIcon();

        int taskQuantity = List.size();

        System.out.println("     Noted. I've removed this task:");
        System.out.println("       [" + taskType + "][" + taskStatus + "] " + taskDescription);
        System.out.println("     Now you have " + taskQuantity + " task(s) in the list.");

        toPrintSeparateLine();
        System.out.println("");
    }
}

package System_output;


import Task_Classes.*;

import java.util.List;
import java.util.Vector;

public class Output_On_Screen {

    /**
     * The greeting with some instruction
     */
    public static void Greeting_Output() {
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        //System.out.println("     **Date and time input format: /by(at): **");
        //System.out.println("     **1. Deadline: YYYY-MM-DD Hour(0-23):Minute(0-59)**");
        //System.out.println("     **2. YYYY-MM-DD Hour(0-23):Minute(0-59) -> Hour(0-23):Minutes(0-59)**");
        //System.out.println("     **3. YYYY-MM-DD Hour(0-23):Minute(0-59) -> YYYY-MM-DD Hour(0-23):Minute(0-59)**");
    }

    /**
     * Sperated_Line
     */
    public static void Separated_Line(){
        System.out.print("    ");
        for(int i=0; i<100; i++){
            System.out.print("_");
        }
        System.out.println("");
    }

    /**
     * Goodbye Output
     */
    public static void GoodBye(){
        System.out.println("     Bye. Hope to see you again soon!");
    }

    /**
     * Output after mark particular task status as done
     *
     * @param List The entire Task List
     * @param n is the Task Sequence number in the Task List
     */
    public static void MarkAsDone_Output(Vector<Task> List, int n){
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("       [" +
                List.get(n).getType() + "][" +
                List.get(n).getStatusIcon() + "] " + List.get(n).getDescription());

        Separated_Line();
    }

    /**
     * Print the list onto screen
     *
     * @param List The entire Task List
     */
    public static void Print_Out_List(Vector<Task> List){
        System.out.println("     Here are the task(s) in your list:");
        for (int i = 0; i < List.size(); i++) {
            int j = i + 1;
            System.out.println("     " + j + "." +
                    "[" + List.get(i).getType() + "]" +
                    "[" + List.get(i).getStatusIcon() + "] " + List.get(i).getDescription());
        }

        Output_On_Screen.Separated_Line();
    }


    /**
     * Output after add Todo task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Todo
     * @param List_Qty the total quantity of task in the List after added current new task
     */
    public static void Output_TodoAdded(Todo newTask, int List_Qty){
        System.out.println("     Got it. I've added this task:");
        System.out.println("        [" + newTask.getType() + "][" + newTask.getStatusIcon() + "] " + newTask.getDescription());
        System.out.println("     Now you have " + List_Qty + " tasks in the list.");
        Separated_Line();
    }

    /**
     * Output after add Deadline task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Deadline
     * @param List_Qty the total quantity of task in the List after added current new task
     */
    public static void Output_DeadlineAdded(Deadline newTask, int List_Qty){
        System.out.println("     Got it. I've added this task:");
        System.out.print("        [" + newTask.getType() + "][" + newTask.getStatusIcon() + "] " + newTask.getDescription());

        System.out.println(" (by: " + newTask.getBy() + ")");
        System.out.println("     Now you have " + List_Qty + " tasks in the list.");
        Separated_Line();
    }

    /**
     * Output after add Event task into the list
     *
     * @param newTask the new task detected from user input and needs to be added to List, type is Event
     * @param List_Qty the total quantity of task in the List after added current new task
     */
    public static void Output_EventAdded (Event newTask, int List_Qty){
        System.out.println("     Got it. I've added this task:");
        System.out.print("        [" + newTask.getType() + "][" + newTask.getStatusIcon() + "] " + newTask.getDescription());

        System.out.println(" (by: " + newTask.getAt() + ")");
        System.out.println("     Now you have " + List_Qty + " tasks in the list.");
        Separated_Line();
    }
}

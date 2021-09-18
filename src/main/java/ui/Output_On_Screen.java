//package ui;
//
//
//import task_classes.Deadline;
//import task_classes.Event;
//import task_classes.Task;
//import task_classes.Todo;
//
//import java.util.Vector;
//
//public class Output_On_Screen extends Ui{
//
////    /**
////     * Print out Separated_Line onto screen
////     */
////    public static void toPrintSeparateLine(){
////        System.out.print("    ");
////        for(int i=0; i<100; i++){
////            System.out.print("_");
////        }
////        System.out.println("");
////    }
//
////    /**
////     * Goodbye Output
////     */
////    public static void printGoodbyeOutput(){
////        System.out.println("     Bye. Hope to see you again soon!");
////    }
//
//    /**
//     * Output after mark particular task status as done
//     *
//     * @param list The entire Task List
//     * @param n is the Task Sequence number in the Task List
//     */
//    public static void printMarkAsDoneOutput(Vector<Task> list, int n, String taskType){
//
//        System.out.println("     Nice! I've marked this task as done:");
//        System.out.print("       [" +
//                list.get(n).getType() + "][" +
//                list.get(n).getStatusIcon() + "] " + list.get(n).getDescription());
//
//        switch (taskType){
//            case "E":
//                String eventDateTime = list.get(n).getAt();
//                System.out.println(" (at: " + eventDateTime + ")");
//
//                break;
//            case "D":
//                String deadlineDateTime = list.get(n).getBy();
//                System.out.println(" (by: " + deadlineDateTime + ")");
//
//                break;
//            default:
//                System.out.println("");
//        }
//
//        toPrintSeparateLine();
//        System.out.println("");
//    }
//
//
//    /**
//     * To print message when user input an invalid input
//     */
//    public static void toPrintNotUnderstandableInputMessage(){
//        System.out.println("    Invalid Input! Please try again!");
//        toPrintSeparateLine();
//        System.out.println("");
//    }
//
//
//}

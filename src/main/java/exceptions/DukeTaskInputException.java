package exceptions;

import screen_output.Output_On_Screen;

public class DukeTaskInputException extends Exception {

    private static String firstWord;
    private static String errorType;

    public DukeTaskInputException(String firstWordInput, String errorTypeInput){

        firstWord = firstWordInput;
        errorType = errorTypeInput;
    }

    public DukeTaskInputException(String errorTypeInput){
        errorType = errorTypeInput;
    }

    public static String getFirstWord() {
        return firstWord;
    }

    public static String getErrorType(){
        return errorType;
    }

    public static void descriptionMissing(String firstWord){
        System.out.println("     ☹ OOPS!!! The description of the " + getFirstWord() + " cannot be empty.");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void dateTimeMissing(){
        System.out.println("     ☹ OOPS!!! The date/time information" + " cannot be empty.");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void markAsDoneTaskNumberMissing(){
        System.out.println("     ☹ OOPS!!! The task number missing.");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void markAsDoneTaskNumberNotInteger(){
        System.out.println("     ☹ OOPS!!! The task number invalid.");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void markAsDoneTaskNumberNotInTaskList(){
        System.out.println("     ☹ OOPS!!! The task number not in the Task List.");
        Output_On_Screen.toPrintSeparateLine();
    }

<<<<<<< HEAD
    public static void markAsDoneTaskNumberOutOfRange(){
=======
    public static void taskIndexOutOfRange(){
>>>>>>> branch-Level-6
        System.out.println("     ☹ OOPS!!! The task number out of range.");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void markAsDoneFormatWrong(){
        System.out.println("     ☹ OOPS!!! The 'Done' format wrong.");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void listIsEmtpy(){
        System.out.println("     ☹ OOPS!!! The Task List is empty.");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void invalidFirstWordInput(){
        Output_On_Screen.toPrintSeparateLine();
        System.out.println("     \u2639" + " OOPS!!! I'm sorry, but I don't know what that means :-(");
        Output_On_Screen.toPrintSeparateLine();
    }

    public static void formatWrong(){
        Output_On_Screen.toPrintSeparateLine();
        System.out.println("     \u2639 OOPS!!! The input format wrong, please try again. :-(");
        Output_On_Screen.toPrintSeparateLine();
    }
}

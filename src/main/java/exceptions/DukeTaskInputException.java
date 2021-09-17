package exceptions;

import ui.Output_On_Screen;

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

    /**
     * To get the first word
     *
     * @return the first word
     */
    public static String getFirstWord() {
        return firstWord;
    }

    /**
     * To get the error type
     *
     * @return the error type
     */
    public static String getErrorType(){
        return errorType;
    }



    /**
     * To print the date or time missing message
     */
    public static void dateTimeMissing(){
        System.out.println("     ☹ OOPS!!! The date/time information" + " cannot be empty.");
        Output_On_Screen.toPrintSeparateLine();
    }

    /**
     * To print the error message about the task number user keyed-in which out of range
     */
    public static void markAsDoneTaskNumberMissing(){
        System.out.println("     ☹ OOPS!!! The task number missing.");
        Output_On_Screen.toPrintSeparateLine();
    }

    /**
     * To print the error message when the task number user keyed in is not an integer
     */
    public static void markAsDoneTaskNumberNotInteger(){
        System.out.println("     ☹ OOPS!!! The task number invalid.");
        Output_On_Screen.toPrintSeparateLine();
    }

    /**
     * To print out the error message if the task index number is not in the task list
     */
    public static void markAsDoneTaskNumberNotInTaskList(){
        System.out.println("     ☹ OOPS!!! The task number not in the Task List.");
        Output_On_Screen.toPrintSeparateLine();
    }

    /**
     * To print out the error message if the task index is out of range
     */
    public static void taskIndexOutOfRange(){
        System.out.println("     ☹ OOPS!!! The task number out of range.");
        Output_On_Screen.toPrintSeparateLine();
    }

    /**
     * To print out the error message if the markAsDone user keyed in the wrong format
     */
    public static void markAsDoneFormatWrong(){
        System.out.println("     ☹ OOPS!!! The 'Done' format wrong.");
        Output_On_Screen.toPrintSeparateLine();
    }

    /**
     * To print out the description missing error message
     */
    public static void descriptionMissing(){
        System.out.println("     ☹ OOPS!!! The description is missing.");
        Output_On_Screen.toPrintSeparateLine();
    }







    /**
     * To print the error message if user try to reach any task in empty task list
     */
    public static void toPrintListIsEmtpyError(){
        System.out.println("     ☹ OOPS!!! The Task List is empty.");
    }

    public static void toPrintCommandCreateError() {
        System.out.println("     ☹ OOPS!!! The Command you just input was in wrong format.");
    }

    /**
     * To print the error message for the wrong input format
     */
    public static void formatWrong(){
        Output_On_Screen.toPrintSeparateLine();
        System.out.println("     \u2639 OOPS!!! The input format wrong, please try again. :-(");
    }

    /**
     * To print the error message if the first word of user input is not in the detection list:
     */
    public static void invalidFirstWordInput(){
        Output_On_Screen.toPrintSeparateLine();
        System.out.println("     \u2639" + " OOPS!!! I'm sorry, but I don't know what that means :-(");
        Output_On_Screen.toPrintSeparateLine();
    }
}

package User_Input;

import System_output.Output_On_Screen;
import Task_Classes.*;
import Task_Manipulation.Add;
import Task_Manipulation.MarkAsDone;

import java.util.Scanner;
import java.util.Vector;

public class Input_Scanner {
    public static boolean input_start(Vector<Task> List){
        String Ending = "bye";
        String Input;

        Scanner in = new Scanner(System.in);
        Input = in.nextLine();

        String[] Input_Words = Input.split(" ");


        Output_On_Screen.Separated_Line();

        switch(Input_Words[0].toLowerCase()) {
            case "bye":
                Output_On_Screen.GoodBye();
                Output_On_Screen.Separated_Line();

                return false;
            case "list":
                Output_On_Screen.Print_Out_List(List);

                return true;
            case "done":

                return MarkAsDone.Mark_As_Done(List, Input_Words, Input);
            case "deadline":
                Add.addDeadlineTask(List, Input_Words);

                return true;
            case "event":
                Add.addEventTask(List, Input_Words);

                return true;
            default:
                Add.addTask(List, Input);

                return true;
        }
    }
}

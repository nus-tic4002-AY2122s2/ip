import java.util.Vector;

import System_output.Output_On_Screen;
import Task_Classes.Task;
import User_Input.Input_Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Output_On_Screen.Separated_Line();
        Output_On_Screen.Greeting_Output();
        Output_On_Screen.Separated_Line();
        System.out.println("");

        Vector<Task> List = new Vector<Task>();

        boolean n = true;
        while(n){
            n = Input_Scanner.input_start(List);
            System.out.println("");
        }
    }
}

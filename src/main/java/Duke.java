import java.util.Vector;

import System_output.Greeting;
import User_Input.Input_Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Greeting.Separated_Line();
        Greeting.Greeting_Output();
        Greeting.Separated_Line();
        System.out.println("");

        Vector<String> List = new Vector<String>();

        boolean n = true;
        while(n){
            n = Input_Scanner.input_start(List);
            System.out.println("");
        }
    }
}

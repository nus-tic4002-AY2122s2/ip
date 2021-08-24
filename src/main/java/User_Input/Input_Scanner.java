package User_Input;

import System_output.Greeting;

import java.util.Scanner;
import java.util.Vector;

public class Input_Scanner {
    public static boolean input_start(Vector<String> List){
        String Ending = "bye";
        String Input;

        Scanner in = new Scanner(System.in);
        Input = in.nextLine().toLowerCase();

        Greeting.Separated_Line();

        switch(Input){
            case "bye":
                Greeting.GoodBye();
                Greeting.Separated_Line();
                return false;
            case"list":
                for(int i = 0; i<List.size(); i++){
                    int j = i + 1;
                    System.out.println("     " + j + "." + List.get(i));
                }

                Greeting.Separated_Line();

                return true;
            default:
                List.add(Input);

                System.out.println("     added:" + Input);
                Greeting.Separated_Line();

                return true;
        }
    }
}

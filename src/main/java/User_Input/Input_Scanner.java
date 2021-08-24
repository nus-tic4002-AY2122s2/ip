package User_Input;

import System_output.Output_On_Screen;
import Task_Classes.Task;
import Task_Manipulation.Add;

import java.util.Scanner;
import java.util.Vector;

public class Input_Scanner {
    public static boolean input_start(Vector<Task> List){
        String Ending = "bye";
        String Input;

        Scanner in = new Scanner(System.in);
        Input = in.nextLine().toLowerCase();

        String[] Input_Words = Input.split(" ");


        Output_On_Screen.Separated_Line();

        switch(Input_Words[0]) {
            case "bye":
                Output_On_Screen.GoodBye();
                Output_On_Screen.Separated_Line();
                return false;
            case "list":
                System.out.println("     Here are the task(s) in your list:");
                for (int i = 0; i < List.size(); i++) {
                    int j = i + 1;
                    System.out.println("     " + j + ".[" + List.get(i).getStatusIcon() + "] " + List.get(i).getDescription());
                }

                Output_On_Screen.Separated_Line();

                return true;
            case "done":

                switch(Input_Words.length){
                    case 2:
                        // check whether the second string is an integer
                        if(Input_Words[1].matches("\\d+")){
                            if(Integer.parseInt(Input_Words[1]) > 0){
                                List.get(Integer.parseInt(Input_Words[1]) - 1).markAsDone();
                                Output_On_Screen.MarkAsDone_Output(List, Integer.parseInt(Input_Words[1]) - 1);
                            }
                            else{
                                Add.addTask(List, Input);
                            }
                        }
                        else{
                            Add.addTask(List, Input);
                        }

                        return true;
                    default:
                        Add.addTask(List, Input);
                }

                return true;
            default:
                Add.addTask(List, Input);

                return true;
        }
    }
}

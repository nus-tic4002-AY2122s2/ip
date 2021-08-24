

import java.util.Scanner;



public class Echo {
    public static int Chat_Echo(){
        String Ending = "bye";
        String Input;

        Scanner in = new Scanner(System.in);
        Input = in.nextLine().toLowerCase();

        Greeting.Separated_Line();

        switch(Input){
            case "bye":
                Greeting.GoodBye();
                Greeting.Separated_Line();
                return 2;
            default:
                System.out.println("     " + Input);
                Greeting.Separated_Line();
                return 1;
        }
    }
}

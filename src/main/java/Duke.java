import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("___________________________________________");
        System.out.println("Hello! I'm Duke\nWHat can I do for you?");
        System.out.println("___________________________________________\n");

        String list[];
        list = new String[1000];
        int i=0;

        while (true) {
            Scanner input = new Scanner(System.in);
            String myString = "";
            myString+= input.nextLine();
            if (myString.equals("bye") || myString.equals("Bye") || myString.equals("BYE")) {
                System.out.println("   Bye. Hope to see you again soon!");
                break;
            }
            else {
                System.out.println("   " + myString + "\n");
            }
        }
    }
}

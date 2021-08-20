import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String horizLine = "____________________________________________________________";

        System.out.println(horizLine);
        System.out.println("Hello! I'm Jarvis");
        System.out.println("What can I do for you?");
        System.out.println(horizLine);

        Scanner userInput = new Scanner(System.in);
        System.out.println(userInput.nextLine());
        //System.out.println("Bye. Hope to see you again soon!");
        //System.out.println(horizLine);
    }
}

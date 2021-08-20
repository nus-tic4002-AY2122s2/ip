import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        // Variables
        String horizLine = "____________________________________________________________";

        // Init
        System.out.println("Hello! I'm Jarvis");
        System.out.println("What can I do for you?");
        System.out.println(horizLine);

        // Read user input
        Scanner userInput = new Scanner(System.in);
        String inputTxt = userInput.nextLine();
        while (!inputTxt.equals("bye")) {
            System.out.println(inputTxt);
            System.out.println(horizLine);
            inputTxt = userInput.nextLine();
        }

        // Finalise
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizLine);
    }
}

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        // Variables
        String horizLine = "____________________________________________________________";
        String[] inputList = new String[100];

        // Init
        System.out.println("Hello! I'm Jarvis");
        System.out.println("What can I do for you?");
        System.out.println(horizLine);

        // Read user input
        Scanner userInput = new Scanner(System.in);
        String inputTxt = userInput.nextLine();
        for (int i = 0; i < inputList.length; i++) {
            if (inputTxt.equals("bye")) {
                break;
            }

            inputList[i] = inputTxt;
            System.out.println("added: " + inputTxt);
            System.out.println(horizLine);
            inputTxt = userInput.nextLine();
        }

        // Finalise
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizLine);
    }
}

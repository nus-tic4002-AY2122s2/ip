import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        // Variables
        String horizLine = "____________________________________________________________";
        Task[] tasks = new Task[100];

        // Init
        System.out.println("Hello! I'm Jarvis");
        System.out.println("What can I do for you?");
        System.out.println(horizLine);

        // Read user input
        Scanner userInput = new Scanner(System.in);
        String inputTxt = userInput.nextLine();
        for (int i = 0; i < tasks.length; i++) {
            if (inputTxt.equals("bye")) {
                break;
            } else if (inputTxt.startsWith("done")) {
                int idx = Integer.parseInt(inputTxt.split(" ")[1]) - 1;
                if (idx < i) {
                    tasks[idx].setDone();
                    System.out.println("Nice! I've marked this as done:");
                    System.out.println(tasks[idx].getTask());
                } else {
                    System.out.println("Task out of limit");
                }
                i--;
            } else if (inputTxt.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int j = 0; j < i; j++) {
                    System.out.println((j + 1) + ". " + tasks[j].getTask());
                }
                i--;
            } else {
                tasks[i] = new Task(inputTxt);
                System.out.println("added: " + inputTxt);
            }

            System.out.println(horizLine);
            inputTxt = userInput.nextLine();
        }

        // Finalise
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(horizLine);
    }
}

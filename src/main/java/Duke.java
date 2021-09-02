import java.util.Scanner;

public class Duke {
    // Variables
    static final String HORIZ_LINE = "____________________________________________________________";

    // Methods
    private static void initApp() {
        System.out.println("Hello! I'm Jarvis");
        System.out.println("What can I do for you?");
        System.out.println(HORIZ_LINE);
    }

    private static void finaliseApp() {
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(HORIZ_LINE);
    }

    private static void runApp(Task[] tasks) {
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
            } else if (inputTxt.startsWith("todo")) {
                tasks[i] = new Todo(inputTxt.substring(5));
                System.out.println("added: " + tasks[i].getTask());
            } else if (inputTxt.startsWith("deadline")) {
                String[] deadlineSplit = inputTxt.substring(9).split("/by");
                tasks[i] = new Deadline(deadlineSplit[0].trim(), deadlineSplit[1].trim());
                System.out.println("added: " + tasks[i].getTask());
            } else if (inputTxt.startsWith("event")) {
                String[] eventSplit = inputTxt.substring(6).split("/at");
                tasks[i] = new Event(eventSplit[0].trim(), eventSplit[1].trim());
                System.out.println("added: " + tasks[i].getTask());
            } else {
                System.out.println("Invalid input");
                i--;
            }

            System.out.println("Total tasks: " + (i + 1));
            System.out.println(HORIZ_LINE);
            inputTxt = userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        Task[] tasks = new Task[100];
        initApp();
        runApp(tasks);
        finaliseApp();
    }
}

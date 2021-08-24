package ip.duke;

import java.lang.String;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * LisGenie Chat Bot - tasks management assistant app.
 *
 * </P>Deals with user tasks registry, chat service and administration.
 *
 * <P>Note that tasks are stored as Task objects in a Task[] array (max size: 100).
 *
 * @author Gwee Yeu Chai
 * @version 1.0
 */
public class Duke {
    private static final Task[] TASKS = new Task[100];
    private static int index;

    // Opening Greetings
    static void greet() {
        System.out.println("Hello! I'm LisGenie");
        System.out.println("What can I do for you?");
    }
    // Bye Message
    static void bye() {
        System.out.printf("Bye. Hope to see you again soon!%n");
    }

    // horizontal line draws method
    static void drawLine() {
        System.out.print("          ");
        Stream.generate(() -> "_").limit(65).forEach(System.out::print);
        System.out.println();
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();
        try (Scanner sc = new Scanner(System.in)) {
            String input;
            // conversions loop
            do {
                System.out.printf("%nMasterOm : ");
                input = sc.nextLine().trim();
                if (input.isEmpty()) {
                    sc.nextLine();
                    echoEmptyInput();
                }
            } while (!echoBye(input));
        }
    }

    private static boolean echoBye(String input) {
        drawLine();
        // Exit Program branch
        if (input.equals("bye")) {
            System.out.print("LisGenie : ");
            bye();
            drawLine();
            return true;
        } else {
            // Conversation runs
            String[] words = null;
            // check & split multiple words in input to a string array
            if(input.indexOf(" ") > 0){
                words = input.split(" ", 2);
                input = words[0].trim();
            }
            switch (input) {
            case "done":
                try {
                    int idx;
                    idx = Integer.parseInt(words[1].trim()) - 1;
                    if (idx < 0 || idx > 99) {
                        echoOffList(idx);
                    } else {
                        updateDone(idx);
                    }
                } catch (NumberFormatException ex) {
                    echoNotNum();
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err){
                    echoNoTaskNum();
                }
                break;
            case "list":
                echoList();
                break;
            case "todo":
                try {
                    addTodo(words[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err){
                    echoNoDesc();
                }
                break;

            case "deadline":
                try {
                    addDeadline(words[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err){
                    echoNoBy();
                }
                break;
            case "event":
                try {
                    addEvent(words[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err){
                    echoNoAt();
                }
                break;
            case "":
                break;
            default:
                System.out.printf("%11s", " ");
                System.out.println("An incorrect command, Master?");
                break;
            }
            drawLine();
        }
        return false;
    }

    private static void addDeadline(String input) {
        String[] parts = input.split(" /by ", 2);
        TASKS[index] = new Deadline(parts[0].trim(), parts[1].trim());
        echoAdded(TASKS[index]);
        ++index;
    }
    private static void addEvent(String input) {
        String[] parts = input.split(" /at ", 2);
        TASKS[index] = new Event(parts[0].trim(), parts[1].trim());
        echoAdded(TASKS[index]);
        ++index;
    }

    private static void addTodo(String input) {
        TASKS[index] = new Todo(input);
        echoAdded(TASKS[index]);
        ++index;
    }

    private static void updateDone(int idx){
        Task item = TASKS[idx];
        if(item != null) {
            item.setDone();
            echoDone(item);
        }else{
            echoNoEntries();
        }
    }

    private static void echoAdded(Task input) {
        int count = index + 1;
        System.out.printf("%11s", " ");
        System.out.println("Got it. I've added this task:");
        System.out.printf("%13s", " ");
        System.out.printf("[%s][%s] %s%n", input.getId(), input.getStatusIcon(), input);
        System.out.printf("%11s", " ");
        System.out.printf("Now you have %d %s in the list.%n", count, count == 1 ? "task" : "tasks");
    }

    private static void echoDone(Task item) {
        System.out.printf("%11s", " ");
        System.out.println("Nice! I've marked this task as done:");
        System.out.printf("%13s", " ");
        System.out.printf("[%s] %s%n", item.getStatusIcon(), item);

    }

    private static void echoEmptyInput() {
        System.out.printf("%11s", " ");
        System.out.println("eh...Om! Empty string to skip here, O Master! Retry again?");
    }

    private static void echoList() {
        System.out.printf("%11s", " ");
        System.out.printf("Here are the tasks in your list:%n");

        int i = 1;
        for (Task s : TASKS) {
            if (s != null)
                System.out.printf("%12d.[%s][%s] %s%n", i++,s.getId(), s.getStatusIcon(), s);
        }
    }

    private static void echoNoAt() {
        System.out.printf("%11s", " ");
        System.out.println("The event...and happening at what time? O Master?");
    }

    private static void echoNoBy() {
        System.out.printf("%11s", " ");
        System.out.println("The task...and by what dateline? O Master?");
    }

    private static void echoNoDesc() {
        System.out.printf("%11s", " ");
        System.out.println("Eh...forgot The task description, O Master?");
    }

    private static void echoNoEntries() {
        System.out.printf("%11s", " ");
        System.out.println("O! Task not in list, Master? Add a task? Retry?");
    }

    private static void echoNoTaskNum() {
        System.out.printf("%11s", " ");
        System.out.println("Om? O Master...forgot the Task's digit number after 'done'?");
    }

    private static void echoNotNum() {
        System.out.printf("%11s", " ");
        System.out.println("O Master...Task number must use digit(s) only! Omm!");
    }

    private static void echoOffList(int idx) {
        System.out.printf("%11s", " ");
        System.out.println("Item position outside of list (1 - 100): " + (idx+1) + " Omm??");
    }
}


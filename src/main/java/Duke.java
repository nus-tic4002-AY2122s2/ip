import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Duke {
    private static final Task[] table = new Task[100];
    private static int index;

    // Opening Greetings
    static void greet() {
        System.out.println("Hello! I'm LisGenie");
        System.out.println("What can I do for you?");
    }

    static void bye() {
        System.out.printf("Bye. Hope to see you again soon!%n");
    }

    // horizontal line draws method
    static void lineDraw() {
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
        lineDraw();
        // Exit Program branch
        if (input.equals("bye") || input.equals("exit")) {
            System.out.print("LisGenie : ");
            bye();
            lineDraw();
            return true;
        } else {
            // Conversation runs
            String head = "";
            Scanner str = new Scanner(input);

            if(str.hasNext()) {
                head = str.next();
            }

            switch (head) {
                case "done":
                    try {
                        int idx = str.nextInt() - 1;

                        if (idx < 0 || idx > 99) {
                            echoOffList(idx);
                        } else {
                            updateDone(idx);
                        }

                    } catch (InputMismatchException ex) {
                        echoNotNum();
                    }catch (NoSuchElementException err){
                        echoNoTaskNum();
                    }
                    break;
                case "list":
                    echoList();
                    break;
                case "":
                    break;
                default:
                    addEntry(input);
                    break;
            }

            lineDraw();
            str.close();
        }

        return false;
    }

    private static void addEntry(String input) {
        table[index++] = new Task(input);
        echoAdded(input);
    }

    private static void updateDone(int idx){
        Task item = table[idx];

        if(item != null) {
            item.setDone(true);
            echoDone(item);
        }else{
            echoNoEntries();
        }
    }

    private static void echoAdded(String input) {
        System.out.println("LisGenie : added: " + input);
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
        for (Task s : table) {
            if (s != null)
                System.out.printf("%12d.[%s] %s%n", i++, s.getStatusIcon(), s);
        }
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
        System.out.println("Item position outside of list (1 - 100): Omm!! " + (idx+1));
    }
}


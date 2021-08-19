import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class Duke {
    static LinkedHashSet<String> table = new LinkedHashSet<>(100);

    static void greet(){
        System.out.println("Hello! I'm LisGenie");
        System.out.println("What can I do for you?");
    }

    static void bye(){
        System.out.printf("Bye. Hope to see you again soon!%n");
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        greet();

        Scanner sc = new Scanner(System.in);
        String input;
        do {
            System.out.println();
            System.out.print("MasterOm : ");
            input = sc.nextLine();
            lineDraw();
        } while (!echoBye(input));

        sc.close();
    }

    static void lineDraw(){
        System.out.print("          ");
        Stream.generate(() -> "_").limit(65).forEach(System.out::print);
        System.out.println();
    }

    private static boolean echoBye(String input) {
        if (input.equals("bye")) {
            System.out.print("LisGenie : ");
            bye();
            lineDraw();
            return true;
        } else {
            switch (input.split(" ")[0]) {
                case "list":
                    int i = 1;
                    for (String s : table) {
                        System.out.printf("%12d. %s%n", i++, s);
                    }
                    break;
                default:
                    table.add(input);
                    System.out.println("LisGenie : added: " + input);
                    break;
            }

            lineDraw();
        }

        return false;
    }
}

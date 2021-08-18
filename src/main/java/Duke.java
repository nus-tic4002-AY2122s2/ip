import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.stream.Stream;

public class Duke {
    static void greet(){
        System.out.println("Hello! I'm LisGenie");
        System.out.println("What can I do for you?");
    }

    static void bye(){
        System.out.printf("Bye. Hope to see you again soon!%n");
    }

    static void lineDraw(){
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

        Scanner sc = new Scanner(System.in);
        String input = "";

        while(true) {
            System.out.println();
            System.out.print("MasterOm : ");
            input = sc.nextLine();
            lineDraw();

            if (input.equals("bye")) {
                System.out.print("LisGenie : ");
                bye();
                lineDraw();
                break;
            } else {
                System.out.println("LisGenie : " + input);
                lineDraw();
            }
        }

        sc.close();
    }
}

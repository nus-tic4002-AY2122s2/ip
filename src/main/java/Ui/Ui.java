package Ui;

public class Ui {
    public static  void  welcome () {
        print("Hello! I'm Duke\n" + "          What can I do for you?");
    }

    public static void bye () {
        print("Bye. Hope to see you again soon!\n");
    }

    public static void print(String message) {
        System.out.println("     ____________________________________________________________");
        System.out.println("          " + message);
        System.out.println("     ____________________________________________________________");
    }
}

package Ui;

public class Ui {
    static  void  welcome () {
        print("     Hello! I'm Duke\n" + "     What can I do for you?\n");
    }

    public void bye () {
        print("     Bye. Hope to see you again soon!\n");
    }

    static void print(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");
    }
}

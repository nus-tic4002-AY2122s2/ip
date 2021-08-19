package duke.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public final class Message implements PropertyChangeListener {
    public Message() { }

    /*
    echo prints out the String parameter passed to it
     */
    public static void echo(String input) {
        System.out.print("\t");
        System.out.println(input);
    }

    public static void addTask(String input) {
        System.out.print("\t added:");
        echo(input);
    }

    public static void exit() {
        System.out.println("\n👋 Bye, see ya ~ \n");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        var list = (ArrayList<String>) evt.getNewValue();
        String newTask = list.get(list.size() - 1);
        this.addTask(newTask);
    }

    public static void greeting() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("👋 from\n" + logo);

        System.out.println("You may spell your wish 🧞‍ \n");
    }
}

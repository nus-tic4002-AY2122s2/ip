package duke.ui;

import java.util.ArrayList;

import duke.storage.TempTaskList;

/**
 * Message Class offers the one and only place to look for
 * and amend the messages that will print on screen
 */
public final class Message {
    public Message() { }

    /**
     * echo prints out the String parameter passed to it
     * @param input
     */
    public static void echo(String input) {
        System.out.print("\t");
        System.out.println(input);
    }

    /**
     * add Task msg
     * @param input
     */
    public static void taskAdd (String input) {
        System.out.print("\tadded:");
        echo(input);
    }

    /**
     * add task msg
     * @param tasks
     */
    public static void taskAdd(TempTaskList tasks) {
        System.out.println("\tadded: " + tasks.get(tasks.size() - 1).toString());
        tasks.tellStats();
    }

    /**
     * empty list msg
     */
    public static void emptyList() {
        System.out.println("\tZero task, add something new!");
    }

    /**
     * delete task msg
     * @param tasks
     */
    public static void taskDelete(ArrayList tasks) {
        System.out.println("\tRoger. Below get removed: ");
        tasks.stream().forEach(System.out::println);
    }

    /**
     * task done msg
     * @param tasks
     * @param index
     */
    public static void taskDone(TempTaskList tasks, int index) {
        System.out.println("\tMarked below as DONE:");
        System.out.println("\t" + tasks.get(index).toString());
        tasks.tellStats();
    }

    /**
     * task marked as undone msg
     * @param tasks
     * @param index
     */
    public static void taskUndone(TempTaskList tasks, int index) {
        System.out.println("\tMarked below as UNDONE:");
        System.out.println("\t" + tasks.get(index).toString());
        tasks.tellStats();
    }

    /**
     * msg prints [1/5] [done/total] task
     * @param numTask
     * @param numDoneTask
     */
    public static void tellTaskNum(int numTask, int numDoneTask) {
        System.out.println("\tTask completion status: "
                            + numDoneTask + " / " + numTask);
    }

    public static void exit() {
        System.out.println("\n👋 Bye, see ya ~ \n");
    }

    public static String exceptionUnknownCommand() {
        return "X_X : Unknown command, please try again";
    }

    public static String exceptionNumArgs() {
        return "X_X : Wrong number of argument, please try again";
    }

    public static String exceptionInvalidArgs() {
        return "X_X : Contains invalid argument, please try again";
    }

    public static String exceptionNoDate() {
        return "X_X : Please give a proper date for this type of task, please try again";
    }

    /**
     * duke linus text string
     */
    public static void greeting() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("👋 from\n" + logo);

        System.out.println("You may spell your wish 🧞\n");
    }
}

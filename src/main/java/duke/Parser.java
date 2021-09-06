package duke;
/**
 * Stores method to understand user command.
 * */
public class Parser {
    /**
     * Finding out the command keyed by user.
     * @param fullCommand user full command.
     * @return user command.
     * */
    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }
    /**
     * Finding out the index keyed user.
     * @param fullCommand user full command.
     * @return index.
     * */
    public static int taskNumber(String fullCommand) {
        int index = Integer.parseInt(fullCommand.split(" ")[1]) - 1;
        return index;
    }
    /**
     * Finding out the description keyed by user.
     * @param fullCommand user full command.
     * @return description
     * */
    public static String description(String fullCommand) {
        String[] s1 = fullCommand.split(" ");
        String[] s2 = fullCommand.split(" /");
        return s2[0].replace(s1[0] + " ", "");
    }
    /**
     * Finding out the date keyed by user.
     * @param fullCommand user full command.
     * @return date in string.
     * */
    public static String date(String fullCommand) {
        String[] s1 = fullCommand.split(" /");
        String[] s2 = s1[1].split(" ");
        return s1[1].replace(s2[0] + " ", "");
    }
}

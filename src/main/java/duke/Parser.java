package duke;

public class Parser {
    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static int taskNumber(String fullCommand) {
        int index = Integer.parseInt(fullCommand.split(" ")[1]) - 1;
        return index;
    }

    public static String description(String fullCommand) {
        String[] s1 = fullCommand.split(" ");
        String[] s2 = fullCommand.split(" /");
        return s2[0].replace(s1[0] + " ", "");
    }

    public static String date(String fullCommand) {
        String[] s1 = fullCommand.split(" /");
        String[] s2 = s1[1].split(" ");
        return s1[1].replace(s2[0] + " ", "");
    }
}

public class Parser {
    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static int taskNumber(String fullCommand) {
        int index = Integer.parseInt(fullCommand.split(" ")[1]) - 1;
        assert index >= 0: "The index of task must be greater than 0";
        return index;
    }

    public static String description(String fullCommand) {
        String[] s1 = fullCommand.split(" ");
        String[] s2 = fullCommand.split("/");
        return s2[0].replace(s1[0] + " ", "");
    }

    public static String deadlineDate(String fullCommand) {
        return fullCommand.split("/by ")[1];
    }

    public static String eventDate(String fullCommand) {
        return fullCommand.split("/at ")[1];
    }
}

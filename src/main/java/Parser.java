public class Parser {
    public static String command(String fullCommand) {
        return fullCommand.split(" ")[0].toLowerCase();
    }

    public static int taskNumber(String fullCommand) {
        int index = Integer.parseInt(fullCommand.split(" ")[1]) - 1;
        assert index >= 0: "The index of task must be greater than 0";
        return index;
    }
}

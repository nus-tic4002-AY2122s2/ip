package duke.commands;


import java.time.format.DateTimeFormatter;

public class UpdateCommand<T> extends Command{
    public static final String COMMAND_WORD = "update";

    public static final String MESSAGE_USAGE = "||update";
    private int targetIndex;
    private String toUpdate;
    private T newValue;

    public UpdateCommand(int targetIndex, String toUpdate, T newValue){
        this.targetIndex = targetIndex;
        this.toUpdate = toUpdate;
        this.newValue = newValue;
    }

    @Override
    public String execute() {
        String commandResult = "";
        commandResult = Integer.toString(targetIndex) + " " + toUpdate + " " + newValue.toString();
        return commandResult;
    }
}

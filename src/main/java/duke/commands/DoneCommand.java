package duke.commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * mark a task as done statement based on the index.
 */
public class DoneCommand extends Command {
    public static final String COMMAND_WORD = "done";

    public static final String MESSAGE_USAGE = "||"
            + COMMAND_WORD + ": mark a task as done status, there are two syntax.\n"
            + "Syntax 1(without finish time): done INDEX\n"
            + "Example: " + COMMAND_WORD + " 2 (this command will mark the No.2 task as Done status "
            + "and the default finish time is the current time)\n"
            + "Syntax 2(with finish time): done INDEX on/TIME(YYYY-MM-dd HHmm)\n"
            + "Example: " + COMMAND_WORD + " 2 on/2019-12-01 1200(this command will mark the No.2 task as Done status "
            + "and finish time is 01 Dec 2019 12:00";
    private LocalDateTime finishTime;

    /**
     * Constructor of the DoneCommand
     */
    public DoneCommand(int[] targetIndex, LocalDateTime finishTime) {
        super(targetIndex);
        this.finishTime = finishTime;
    }

    @Override
    public String execute() {
        String commandResult = "";
        for (int i : getTargetIndex()) {
            taskList.getTaskByIdx(i).markAsDone(finishTime);
            commandResult += taskList.getTaskByIdx(i) + " is done on "
                    + finishTime.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")) + "\n";
        }
        return commandResult;
    }
}

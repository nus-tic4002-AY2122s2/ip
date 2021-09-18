package duke.command;

/**
 * It prints out all key from the HashMap that contains
 * key-command pair
 */
public class AllCommandCmd implements Command {
    private CommandFactory commands;

    public AllCommandCmd(CommandFactory commands) {
        this.commands = commands;
    }

    @Override
    public void run(String[] args) {
        commands.print();
    }
}

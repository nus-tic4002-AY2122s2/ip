package duke.command;

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

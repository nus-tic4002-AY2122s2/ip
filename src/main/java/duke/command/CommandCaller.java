package duke.command;

import duke.parse.StringParser;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Stack;

/**
 * A Invoker Class in Command Pattern
 */
public class CommandCaller implements PropertyChangeListener {
    private CommandFactory commandFactory;
    public Stack<Command> undoableCommandHistory = new Stack<>();

    public CommandCaller() {}
    public CommandCaller(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void runCommand(Command cmd, String[] args) {
        if (cmd instanceof UndoableCommand) {
            undoableCommandHistory.add(cmd);
        }
        cmd.run(args);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String[] keyArgs = (String[]) evt.getNewValue();
        String key = keyArgs[0];
        String[] args = StringParser.removeFirst(keyArgs);
        this.runCommand(commandFactory.get(key), args);
    }
}

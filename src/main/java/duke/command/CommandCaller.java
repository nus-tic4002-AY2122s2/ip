package duke.command;

import duke.exception.UnknownCommandException;
import duke.parse.StringParser;
import duke.ui.Message;

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
        if (!commandFactory.containsKey(key)) {
            try {
                throw new UnknownCommandException();
            } catch (UnknownCommandException e) {
                Message.echo(e.getMessage());
            }
        } else {
            this.runCommand(commandFactory.get(key), args);
        }
    }
}

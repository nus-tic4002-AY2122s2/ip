package duke;

/*
 *  Parser.java
 *  Defines the flow of commands parse from user's input.
 */

public class Parser {
    /*
     * @param command Command from user's input.
     * @return Command object.
     * @throws DukeException Exception handled.
     */
    static Command parse(String command) throws DukeException {
        //task split by the first spacing
        String[] task = command.split(" ",2);

        //stores task size
        int taskLen = task.length;

        //command defined by user
        command = task[0];

        switch (command) {
        case "list":
            return new ListCommand();
        case "help":
            return new HelpCommand();
        case "bye":
            return new ExitCommand();
        case "save":
            return new SaveCommand();
        case "done":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                return new DoneCommand(Integer.parseInt(task[1]));
            }
        case "update":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                assert task[1].contains("/to") : "Missing /to arguments for update";
                String[] descrip = task[1].split(" /to ", 2);
                System.out.println(descrip[0] + descrip[1]);
                return new UpdateCommand(Integer.parseInt(descrip[0]), descrip[1]);
            }
        case "find":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                return new FindCommand(task[1]);
            }
        case "view":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                return new ViewCommand(task[1]);
            }
        case "delete":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                return new DeleteCommand(Integer.parseInt(task[1]));
            }
        case "todo":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                return new AddCommand(new ToDo(task[1]));
            }
        case "event":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                assert task[1].contains("/at") : "Missing /at arguments for event";
                String[] descrip = task[1].split(" /at ", 2);
                return new AddCommand(new Event(descrip[0], descrip[1]));
            }

        case "deadline":
            if (taskLen < 2) {
                throw new DukeException(command);
            } else {
                assert task[1].contains("/by") : "Missing /by arguments for deadline";
                String[] descrip = task[1].split(" /by ", 2);
                return new AddCommand(new Deadline(descrip[0], descrip[1]));
            }

        default:
            throw new DukeException();
        }
    }
}
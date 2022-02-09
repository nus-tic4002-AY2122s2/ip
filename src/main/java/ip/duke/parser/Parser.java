package ip.duke.parser;

import java.util.Objects;

import ip.duke.exceptions.DukeException;
import ip.duke.tasklist.TaskList;
import ip.duke.ui.Ui;

// THis utility class provides for parsing user inputs to the various wanted tasks.
public class Parser {
    /**
     * This is the method which processes tasks and generates related dialogues.
     *
     * @param command Text input by user.
     * @return A boolean value.
     * @throws DukeException On input error.
     * @see DukeException
     */
    public static boolean hasTask(String command) throws DukeException {
        // Exit the program
        if (command.matches("b|bye")) {
            Ui.bye();
            return true;
        } else {
            // Parses user inputs to run the selected tasks errands
            String[] words = null;
            // Check if multiple words exist in input before splitting into a string array
            if (command.indexOf(" ") > 0) {
                words = command.split(" ", 2);
                command = words[0];
            }

            switch (command) {
            case "l":
            case "list":
                Ui.echoList();
                break;
            case "f":
            case "find":
                try {
                    Ui.echoFind(Objects.requireNonNull(words)[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoDesc("find"), err);
                }
                break;
            case "t":
            case "todo":
                try {
                    TaskList.addTodo(Objects.requireNonNull(words)[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoDesc("todo"), err);
                }
                break;
            case "d":
            case "deadline":
                try {
                    TaskList.addDeadline(Objects.requireNonNull(words)[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoBy(), err);
                }
                break;
            case "e":
            case "event":
                try {
                    TaskList.addEvent(Objects.requireNonNull(words)[1].trim());
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoAt(), err);
                }
                break;
            case "del":
            case "delete":
                try {
                    TaskList.doDelete(Objects.requireNonNull(words)[1]);
                } catch (NumberFormatException ex) {
                    throw new DukeException(Ui.echoNotNum("delete"), ex);
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoTaskNum("delete"), err);
                }
                break;
            case "c":
            case "done":
                try {
                    TaskList.doDone(Objects.requireNonNull(words)[1]);
                } catch (NumberFormatException ex) {
                    throw new DukeException(Ui.echoNotNum("done"), ex);
                } catch (NullPointerException | ArrayIndexOutOfBoundsException err) {
                    throw new DukeException(Ui.echoNoTaskNum("done"), err);
                }
                break;
            case "":
                break;
            default:
                Ui.echoNonInput();
                break;
            }
        }
        return false;
    }
}

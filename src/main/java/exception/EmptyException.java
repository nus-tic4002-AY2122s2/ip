package exception;

/**
 * Signals an error caused by missing a task's description.
 */
public class EmptyException extends Exception {
    public EmptyException(String type) {
        super("☹ OOPS!!! The description of " + type + " cannot be empty.");
    }
}

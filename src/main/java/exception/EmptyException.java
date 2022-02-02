package exception;

/**
 * Signals an error caused by missing a task's description.
 */
public class EmptyException extends Exception {
    public EmptyException(String type) {
        super("\u2639 OOPS!!! The description of " + type + " cannot be empty.");
    }
}

package ip.duke;

public class DukeException extends Exception {
    public DukeException(String errorMsg, Throwable ex) {
        super(errorMsg);
    }
}

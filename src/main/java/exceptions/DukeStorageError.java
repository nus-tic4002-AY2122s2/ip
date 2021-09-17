package exceptions;

public class DukeStorageError extends Exception {
    private String errorType;

    public DukeStorageError() {

    }

    public DukeStorageError (String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return this.errorType;
    }
}

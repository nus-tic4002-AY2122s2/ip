package exceptions;

public class DukeDateTimeError extends Throwable {
    private String errorType;

    public DukeDateTimeError(String errorType) {
        this.errorType = errorType;
    }

    public void inputDateTimeFormatWrong() {
        System.out.println("     Oops! The dateTime input format wrong. Please try again.");
    }
}

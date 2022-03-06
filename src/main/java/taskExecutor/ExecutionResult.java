package taskExecutor;

public class ExecutionResult {
    private String error = "";
    private String[] result;
    private String systemMessage = "";

    public void setSystemMsg(String msg) {
        systemMessage = msg;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String err) {
        error = err;
    }

    public String getSystemMessage() {
        return this.systemMessage;
    }

    public String[] getResult() {
        return this.result;
    }

    public void setResult(String[] newResult) {
        result = newResult;
    }

}

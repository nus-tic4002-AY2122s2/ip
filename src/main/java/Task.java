public class Task {
    protected String description;
    protected Boolean mark = false;
    protected char toDo;
    protected  String additionalDetails;

    public Task(String description, boolean mark, char toDo, String additionalDetails) {
        this.description = description;
        this.mark = mark;
        this.toDo = toDo;
        this.additionalDetails = additionalDetails;
    }

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getMark() {
        return mark;
    }

    public void setMark(Boolean mark) {
        this.mark = mark;
    }

    public char getToDo() {
        return toDo;
    }

    public void setToDo(char toDo) {
        this.toDo = toDo;
    }

    public String getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(String additionalDetails) {
        this.additionalDetails = additionalDetails;
    }
}

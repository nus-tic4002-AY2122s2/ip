public class Task {
    protected String description;
    protected Boolean mark = false;

    public Task(String description, boolean mark) {
        this.description = description;
        this.mark = mark;
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
}